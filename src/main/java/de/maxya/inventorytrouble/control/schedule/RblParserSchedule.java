package de.maxya.inventorytrouble.control.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLGameSearchOptionToSend;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.control.RBLGameService;
import de.maxya.inventorytrouble.control.email.MailController;
import de.maxya.inventorytrouble.control.mapper.RBLGameSearchOptionMapper;
import de.maxya.inventorytrouble.control.rblparser.RBLPageParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RblParserSchedule {

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);
    private static final int FIXED_DELAY = 10000;
    private static final int STATUS_EACH_HOURS = 2;

    private boolean stopped = false;
    private StringBuilder stringBuilder = new StringBuilder();

    @Autowired
    RBLPageParser parser;

    @Autowired
    RBLGameService service;

    private RblGameChecker checker;
    private List<String> listOfGameNames;

    public RblParserSchedule(){
        checker = new RblGameChecker();
        RBLRuleSektorB b = new RBLRuleSektorB();
        RBLRuleSektorD d = new RBLRuleSektorD();
        RBLRuleSektorD dMitNachbarn = new RBLRuleSektorD();
        dMitNachbarn.searchNeighbours(true);

        RBLGameSearchOption searchBremen = new RBLGameSearchOption("RB Leipzig-SV Werder Bremen");
        searchBremen.addRule(b);

        checker.addSearchOption(searchBremen);

        checker.logSearchOptions();

        listOfGameNames = new ArrayList<>();
    }

    public List<RBLGameSearchOption> getSearchOptions(){
        return checker.getSearchOptions();
    }

    int number = 0;

    int waitSomeCycles = 1;
    int count = 1;

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Scheduled(initialDelay = 1000, fixedDelay = FIXED_DELAY)
    public void run() {
        checker.reset();
        listOfGameNames.clear();
        if (stopped) {
            LOGGER.info("RBL-Parser stopped");
            return;
        }
        if (count < waitSomeCycles){
            count++;
            LOGGER.log(Level.INFO,"WaitCycle: " + count);
            return;
        }else{
            count = 1;
        }

        if(number % 20 == 0){
            LOGGER.log(Level.INFO,"Count: " + service.count());
            LOGGER.log(Level.INFO,"Count Sitzplatz: " + service.countSitzplatze());
            checker.logSearchOptions();
            number = 1;
        }
        number++;

        List<RBLGames> erg = parser.extractFreePlaces();
        if (parser.isInWarteRaum()){
            LOGGER.log(Level.WARN,"Warteraum wait 50 Cycles");
            waitSomeCycles = 50;
        }else{
            waitSomeCycles = 1;
        }

        fillGameList(erg);

        int countOfGamesWithBBlockTickets = 0;

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

        ObjectMapper mapper = new ObjectMapper();
        Optional<RBLGames> firstGame = checker.getGamesToSave().stream().findFirst();
        if (firstGame.isPresent()){
            try {
               this.template.send("topic1", firstGame.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringBuilder spieleBuilder = new StringBuilder();
        StringBuilder begegnungen = new StringBuilder();

        if (findings.size() > 0) {
            findings.stream().forEach(result ->{
                begegnungen.append("" + result.Name + " ");
                spieleBuilder.append("" + result.Name + " ");
                spieleBuilder.append(result.Info + " ");
                spieleBuilder.append(result.sitzplatz.toString() + " ");
                spieleBuilder.append(result.link + " \n\n");
            });
            mc.sendOhneAnhang("lutzfinke2010@gmail.com", "!! "+findings.size()+" Findings " + begegnungen.toString()+ " !!", spieleBuilder.toString());
        } else {
            if (counterHour == haveIWait2Hours()) {
                mc.sendOhneAnhang("lutzfinke2010@gmail.com", "!!! STATUS !!!", text);
                counterHour = 0;
            } else {
                counterHour++;
            }
        }
    }

    private void fillGameList(List<RBLGames> erg) {
        for (Iterator<RBLGames> itPlaces = erg.iterator(); itPlaces.hasNext(); ) {
            RBLGames game = itPlaces.next();
            String name = game.getName();
            if (!listOfGameNames.contains(name)){
                listOfGameNames.add(name);
            }
        }
    }

    public List<String> getListOfGameNames(){
        return listOfGameNames;
    }

    private int haveIWait2Hours() {
        int millisecondsPerHours = 1000 * 60 * 60;
        int millisecondsToWait = millisecondsPerHours * STATUS_EACH_HOURS;
        return Math.round((float)millisecondsToWait / (float)FIXED_DELAY) ;
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
