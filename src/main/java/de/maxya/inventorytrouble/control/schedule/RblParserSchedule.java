package de.maxya.inventorytrouble.control.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLGameSearchOptionToSend;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLRuleResultResponse;
import de.maxya.inventorytrouble.control.RBLGameService;
import de.maxya.inventorytrouble.control.email.MailController;
import de.maxya.inventorytrouble.control.mapper.RBLGameSearchOptionMapper;
import de.maxya.inventorytrouble.control.rblparser.RBLPageParser;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorB;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorD;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RblParserSchedule {

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);
    private static final int FIXED_DELAY = 9000;
    private static final int STATUS_EACH_HOURS = 2;
    int MAX_WAIT_CYCLES = 5;

    private boolean stopped = false;
    private StringBuilder stringBuilder = new StringBuilder();
    private WebSocketMessageSender webSocketSender;

    @Autowired
    RBLPageParser parser;

    @Autowired
    RBLGameService service;

    @Autowired
    SimpMessagingTemplate templateWebSocket;

    @Autowired
    private KafkaTemplate<Object, Object> template;

    private RblGameChecker checker;
    private List<String> listOfGameNames;

    public RblParserSchedule() {
        checker = new RblGameChecker();
        RBLRuleSektorB b = new RBLRuleSektorB();
        RBLRuleSektorD d = new RBLRuleSektorD();
        RBLRuleSektorD dMitNachbarn = new RBLRuleSektorD();
        dMitNachbarn.searchNeighbours(true);

        RblGameSearchOption searchIstanbul = new RblGameSearchOption("RB Leipzig-Galatasaray Istanbul");

        RblGameSearchOption searchFrankfurt = new RblGameSearchOption("RB Leipzig-Eintracht Frankfurt");
        searchFrankfurt.addRule(b);
        //searchFrankfurt.addRule(dMitNachbarn);


        RblGameSearchOption searchDortmund = new RblGameSearchOption("RB Leipzig-Borussia Dortmund");
        searchDortmund.addRule(b);
        searchDortmund.addRule(d);
        searchDortmund.addRule(dMitNachbarn);

        checker.addSearchOption(searchIstanbul);
        checker.addSearchOption(searchFrankfurt);
        checker.addSearchOption(searchDortmund);

        checker.logSearchOptions();

        listOfGameNames = new ArrayList<>();
    }

    public List<RblGameSearchOption> getSearchOptions() {
        return checker.getSearchOptions();
    }

    int number = 0;

    int waitSomeCycles = 1;
    int count = 1;


    @Scheduled(initialDelay = 1000, fixedDelay = FIXED_DELAY)
    public void run() {
        webSocketSender = new WebSocketMessageSender(templateWebSocket, template);
        checker.reset();
        listOfGameNames.clear();
        if (stopped) {
            LOGGER.info("RBL-Parser stopped");
            return;
        }
        if (count < waitSomeCycles) {
            count++;
            webSocketSender.reset().setWaitRoomCounter(count).send();
            LOGGER.log(Level.INFO, "WaitCycle: " + count);
            return;
        } else {
            count = 1;
        }

        if (number % 20 == 0) {
            LOGGER.log(Level.INFO, "Count: " + service.count());
            LOGGER.log(Level.INFO, "Count Sitzplatz: " + service.countSitzplatze());
            checker.logSearchOptions();
            webSocketSender.reset().setSearchOptions(checker.getSearchOptionsForGames()).send();
            number = 1;
        }
        number++;

        List<RBLGames> erg = parser.extractFreePlaces();
        if (parser.isInWarteRaum()) {
            LOGGER.log(Level.WARN, "Warteraum wait "+MAX_WAIT_CYCLES+" Cycles");
            waitSomeCycles = MAX_WAIT_CYCLES;
            return;
        } else {
            waitSomeCycles = 1;
        }

        fillGameList(erg);

        if (erg != null && erg.size() > 0) {
            webSocketSender.reset().setSearchOptions(checker.getSearchOptionsForGames())
                    .setRBLGames(erg)
                    .send();
        }

        List<RBLRuleResult> findings = checker.checkRBLGameList(erg);

        for (Iterator<RBLGames> itPlaces = checker.getGamesToSave().iterator(); itPlaces.hasNext(); ) {
            RBLGames game = itPlaces.next();
            service.createRBLGame("Scheduler", game);
        }

        MailController mc = new MailController();

        String text = "Anzahl Spiele: " + erg.size() + "</br></br>";
        LOGGER.info(text);


        for (Iterator<RBLGames> itPlaces = checker.getGamesToSave().iterator(); itPlaces.hasNext(); ) {
            RBLGames game = itPlaces.next();
            stringBuilder = new StringBuilder();
            stringBuilder.append(game.getName());
            stringBuilder.append(" -> ");
            stringBuilder.append(game.getPlaetze().size());
            stringBuilder.append(" ALL -> ");
            stringBuilder.append(game.getCountBBLock());
            stringBuilder.append(" B ");
            stringBuilder.append(game.getCountDBLock());
            stringBuilder.append(" D ");
            LOGGER.info(stringBuilder.toString());
            text += stringBuilder.toString();
        }

        StringBuilder spieleBuilder = new StringBuilder();
        StringBuilder begegnungen = new StringBuilder();

        if (findings.size() > 0) {
            findings.stream().forEach(result -> {
                begegnungen.append("" + result.Name + " ");
                spieleBuilder.append("" + result.Name + " ");
                spieleBuilder.append(result.Info + " ");
                spieleBuilder.append(result.sitzplatz.toString() + " ");
                spieleBuilder.append(result.link + " \n\n");
            });

            webSocketSender.reset().setFindings(findings).distinct().send();

            mc.sendOhneAnhang("lutzfinke2010@gmail.com", "!! " + findings.size() + " Findings " + begegnungen.toString() + " !!", spieleBuilder.toString());
        } else {
            if (counterHour == haveIWait2Hours()) {
                mc.sendOhneAnhang("lutzfinke2010@gmail.com", "!!! STATUS !!!", text);
                counterHour = 0;
            } else {
                counterHour++;
            }
        }
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private void fillGameList(List<RBLGames> erg) {
        for (Iterator<RBLGames> itPlaces = erg.iterator(); itPlaces.hasNext(); ) {
            RBLGames game = itPlaces.next();
            String name = game.getName();
            if (!listOfGameNames.contains(name)) {
                listOfGameNames.add(name);
            }
        }
    }

    public List<String> getListOfGameNames() {
        return listOfGameNames;
    }

    private int haveIWait2Hours() {
        int millisecondsPerHours = 1000 * 60 * 60;
        int millisecondsToWait = millisecondsPerHours * STATUS_EACH_HOURS;
        return Math.round((float) millisecondsToWait / (float) FIXED_DELAY);
    }

    private int counterHour = 0;

    public void stop() {
        stopped = true;
    }

    public void start() {
        stopped = false;
    }

    public boolean getStatus() {
        return !stopped;
    }

    public void logSearchOptions() {
        checker.logSearchOptions();
    }

    public void changeSearchOptions(RBLGameSearchOptionToSend searchOption) {
        checker.changeSearchOptions(RBLGameSearchOptionMapper.mapToRBLGameSearchOption(searchOption));
    }
}
