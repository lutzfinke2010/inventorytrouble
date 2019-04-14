package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLGameSearchOptionToSend;
import de.maxya.inventorytrouble.boundary.model.RBLGameToSearch;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.control.RBLGameService;
import de.maxya.inventorytrouble.control.email.MailController;
import de.maxya.inventorytrouble.control.login.RblScannerHtmlUnit;
import de.maxya.inventorytrouble.control.mapper.RBLGameSearchOptionMapper;
import de.maxya.inventorytrouble.control.rules.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class RblParserSchedule {

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);
    private static final int FIXED_DELAY = 9000;
    private static final int STATUS_EACH_HOURS = 2;
    int MAX_WAIT_CYCLES = 20;

    private boolean stopped = false;
    private StringBuilder stringBuilder = new StringBuilder();
    private WebSocketMessageSender webSocketSender;

    @Autowired
    RblScannerHtmlUnit parser; //RBLPageParser parser;

    @Autowired
    RBLGameService service;

    @Autowired
    SimpMessagingTemplate templateWebSocket;

    @Autowired
    private KafkaTemplate<Object, Object> template;

    private RblGameChecker checker;
    private List<String> listOfGameNames;
    int number = 0;

    int waitSomeCycles = 1;
    int count = 1;


    public RblParserSchedule() {
        checker = new RblGameChecker();
        listOfGameNames = new ArrayList<>();
    }

    public List<RblGameSearchOption> getSearchOptions() {
        return checker.getSearchOptions();
    }

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

        if (number % 400 == 0 || !parser.isLoggedIn()) {
            login();
        }

        try {
            parser.loadTicketboerse();
        } catch (IOException e) {
            LOGGER.error("loadTicketboerse fehlgeschlagen" + e.getMessage());
        }
        List<RBLGames> erg = parser.getAvaiableGames();

        fillGameList(erg);


        if (number % 20 == 0) {
            LOGGER.log(Level.INFO, "Count: " + service.count());
            LOGGER.log(Level.INFO, "Count Sitzplatz: " + service.countSitzplatze());
            checker.logSearchOptions();
            webSocketSender.reset().setSearchOptions(checker.getSearchOptionsForGames()).send();
            checkAvaiableGames(erg);
        }
        number++;

        if (erg.size() > 0) {
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

    private void login() {
        try {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!1111");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!1111");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!1111");
            System.out.println("!!!!!!!!! LOGIN !!!!!!!!!!!!1111");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!1111");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!1111");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!1111");
            parser.refreshLogin();
        } catch (IOException e) {
            LOGGER.error("refreshLogin fehlgeschlagen" + e.getMessage());
        }
    }

    private void checkAvaiableGames(List<RBLGames> erg) {
        List<String> gamesAvaiable = new ArrayList<>();
        List<RblGameSearchOption> options = checker.getSearchOptionsForGames();
        erg.stream().forEach(rblGames -> {
            options.stream().forEach(option -> {
                if (option.name.equals(rblGames.getName())) {
                    gamesAvaiable.add(option.name);
                }
            });
        });
        gamesAvaiable.stream().forEach(avaibleGame -> {
            LOGGER.info("Game vorhanden: " + avaibleGame);
        });
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

    public List<RBLGames> getAvaiableGames() {
        return parser.getAvaiableGames();
    }

    public void addOrRemoveGameToSearch(RBLGameToSearch gameToSearch) {
        RBLRuleSektorA sektorA = new RBLRuleSektorA();
        RBLRuleSektorB sektorB = new RBLRuleSektorB();
        RBLRuleSektorC sektorC = new RBLRuleSektorC();
        RBLRuleSektorD sektorD = new RBLRuleSektorD();

        Optional<RblGameSearchOption> searchOption = checker.getSearchOptionWithName(gameToSearch.getName());

        if (false == gameToSearch.isAktiv()) {
            if (searchOption.isPresent()) {
                RblGameSearchOption option = searchOption.get();
                option.removeRule(mapClientNameToRuleName(gameToSearch.getSektor()));

                if (searchOption.get().getRules().size() <= 0) {
                    checker.removeSearchOption(gameToSearch.getName());
                }
            }
            return;
        }


        if (false == searchOption.isPresent()) {
            RblGameSearchOption newSearchOption = new RblGameSearchOption(gameToSearch.getName());
            if (gameToSearch.getSektor().equals("A")) {
                newSearchOption.addRule(sektorA);
            }
            if (gameToSearch.getSektor().equals("B")) {
                newSearchOption.addRule(sektorB);
            }
            if (gameToSearch.getSektor().equals("C")) {
                newSearchOption.addRule(sektorC);
            }
            if (gameToSearch.getSektor().equals("D")) {
                newSearchOption.addRule(sektorD);
            }
            checker.addSearchOption(newSearchOption);
        } else {

            if (searchOption.get().containsRule(mapClientNameToRuleName(gameToSearch.getSektor()))) {
                return;
            }

            if (gameToSearch.getSektor().equals("B")) {
                searchOption.get().addRule(sektorB);
            }
            if (gameToSearch.getSektor().equals("D")) {
                searchOption.get().addRule(sektorD);
            }
            if (gameToSearch.getSektor().equals("A")) {
                searchOption.get().addRule(sektorA);
            }
            if (gameToSearch.getSektor().equals("C")) {
                searchOption.get().addRule(sektorC);
            }
        }
    }

    private String mapClientNameToRuleName(String clientName) {
        return "Sektor " + clientName;
    }


}
