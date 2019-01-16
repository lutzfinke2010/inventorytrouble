package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorB;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = InventorytroubleApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
//@SpringBootTest
public class RblParserScheduleTests {

    //@Test
    public void afterResetAllMustBeEmpty() {
        RblGameChecker subject = new RblGameChecker();
        subject.reset();
        Assert.assertTrue(subject.getBodyText().isEmpty());
        Assert.assertTrue(subject.getHeaderText().isEmpty());
        Assert.assertTrue(subject.getGamesToSave().size() == 0);
    }

    //@Test
    public void checkWithEmptyListAllMustBeEmpty() {
        RblGameChecker subject = new RblGameChecker();
        subject.reset();
        subject.checkRBLGameList(new ArrayList<>());
        Assert.assertTrue(subject.getBodyText().isEmpty());
        Assert.assertTrue(subject.getHeaderText().isEmpty());
        Assert.assertTrue(subject.getGamesToSave().size() == 0);
    }

    //@Test
    public void checkWithOneGameWithOutBBlockHeaderAndBodyMustBeEmptyGameListMustContainTheGame() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";

        RblGameChecker subject = new RblGameChecker();
        subject.reset();
        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("1");
        sitzplatz.setKategorie("1");
        sitzplatz.setBereich("1");
        sitzplatz.setSitz("1");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);

        subject.checkRBLGameList(games);
        Assert.assertTrue(subject.getBodyText().isEmpty());
        Assert.assertTrue(subject.getHeaderText().isEmpty());
        Assert.assertTrue(subject.getGamesToSave().size() == 1);
        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }

    //@Test
    public void checkWithOneGameWithBBlockHeaderMustContainNameAndBodyMustContainPlatzGameListMustContainTheGame() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";

        RblGameChecker subject = new RblGameChecker();
        subject.reset();
        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("28");
        sitzplatz.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);

        subject.checkRBLGameList(games);
        Assert.assertEquals("Body not correct", "RB Leipzig - Barca\n" +
                "toller Link\n" +
                "Bereich: 28 Reihe: 2 Sitz: 10", subject.getBodyText().trim());
        Assert.assertEquals("Header not correct","RB Leipzig - Barca ", subject.getHeaderText());
        Assert.assertTrue("Length of List to Save not correct",subject.getGamesToSave().size() == 1);
        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }

    //@Test
    public void checkWithTwoGamesWithBBlockHeaderMustContainNameAndBodyMustContainPlatzGameListMustContainTheGames() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";
        String gameName2 = "RB Leipzig - Deutschland";
        String link2 = "toller Link 2";

        RblGameChecker subject = new RblGameChecker();
        RblGameSearchOption optionB = new RblGameSearchOption("RB Leipzig - Barca");
        optionB.addRule(new RBLRuleSektorB());
        RblGameSearchOption optionD = new RblGameSearchOption("RB Leipzig - Deutschland");
        optionD.addRule(new RBLRuleSektorB());
        subject.reset();
        subject.addSearchOption(optionB);
        subject.addSearchOption(optionD);

        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("28");
        sitzplatz.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        RBLGames gameWithB2 = new RBLGames();
        gameWithB2.setName(gameName2);
        gameWithB2.setLink(link2);
        RBLSitzplatz sitzplatzGame21 = new RBLSitzplatz();
        sitzplatzGame21.setReihe("4");
        sitzplatzGame21.setKategorie("2");
        sitzplatzGame21.setBereich("28");
        sitzplatzGame21.setSitz("133");
        RBLSitzplatz sitzplatzGame22 = new RBLSitzplatz();
        sitzplatzGame22.setReihe("4");
        sitzplatzGame22.setKategorie("2");
        sitzplatzGame22.setBereich("2");
        sitzplatzGame22.setSitz("133");
        RBLSitzplatz sitzplatzGame23 = new RBLSitzplatz();
        sitzplatzGame23.setReihe("4");
        sitzplatzGame23.setKategorie("2");
        sitzplatzGame23.setBereich("30");
        sitzplatzGame23.setSitz("133");
        RBLSitzplatz sitzplatzGame24 = new RBLSitzplatz();
        sitzplatzGame24.setReihe("4");
        sitzplatzGame24.setKategorie("2");
        sitzplatzGame24.setBereich("1");
        sitzplatzGame24.setSitz("133");
        List<RBLSitzplatz> sitzeGame2 = new ArrayList<>();
        sitzeGame2.add(sitzplatzGame21);
        sitzeGame2.add(sitzplatzGame22);
        sitzeGame2.add(sitzplatzGame23);
        sitzeGame2.add(sitzplatzGame24);
        gameWithB2.setPlaetze(sitzeGame2);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);
        games.add(gameWithB2);

        subject.checkRBLGameList(games);
        Assert.assertEquals("Body not correct", "RB Leipzig - Barca\n" +
                "toller Link\n" +
                "Bereich: 28 Reihe: 2 Sitz: 10\n" +
                "\n" +
                "\n" +
                " RB Leipzig - Deutschland\n" +
                "toller Link 2\n" +
                "Bereich: 28 Reihe: 4 Sitz: 133\n"+
                "Bereich: 30 Reihe: 4 Sitz: 133", subject.getBodyText().trim());
        Assert.assertEquals("Header not correct","RB Leipzig - Barca RB Leipzig - Deutschland ", subject.getHeaderText());
        Assert.assertTrue("Length of List to Save not correct",subject.getGamesToSave().size() == 2);
        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }


    //@Test
    public void checkWithTwoGamesWithBBlockAndTwoGamesWithoutBBlockHeaderMustContainNameAndBodyMustContainPlatzGameListMustContainTheGames() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";
        String gameName2 = "RB Leipzig - Deutschland";
        String link2 = "toller Link 2";
        String gameName3 = "RB Leipzig - Frankfurt";
        String link3 = "toller Link 3";
        String gameName4= "RB Leipzig - Man City";
        String link4 = "toller Link 4";

        RblGameChecker subject = new RblGameChecker();
        subject.reset();

        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("28");
        sitzplatz.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        RBLGames gameWithB2 = new RBLGames();
        gameWithB2.setName(gameName2);
        gameWithB2.setLink(link2);
        RBLSitzplatz sitzplatzGame2 = new RBLSitzplatz();
        sitzplatzGame2.setReihe("4");
        sitzplatzGame2.setKategorie("2");
        sitzplatzGame2.setBereich("30");
        sitzplatzGame2.setSitz("133");
        List<RBLSitzplatz> sitzeGame2 = new ArrayList<>();
        sitzeGame2.add(sitzplatzGame2);
        gameWithB2.setPlaetze(sitzeGame2);

        RBLGames gameWithB3 = new RBLGames();
        gameWithB3.setName(gameName3);
        gameWithB3.setLink(link3);
        RBLSitzplatz sitzplatzGame3 = new RBLSitzplatz();
        sitzplatzGame3.setReihe("4");
        sitzplatzGame3.setKategorie("3");
        sitzplatzGame3.setBereich("1");
        sitzplatzGame3.setSitz("133");
        List<RBLSitzplatz> sitzeGame3 = new ArrayList<>();
        sitzeGame3.add(sitzplatzGame3);
        gameWithB3.setPlaetze(sitzeGame3);

        RBLGames gameWithB4 = new RBLGames();
        gameWithB4.setName(gameName4);
        gameWithB4.setLink(link4);
        RBLSitzplatz sitzplatzGame4 = new RBLSitzplatz();
        sitzplatzGame4.setReihe("4");
        sitzplatzGame4.setKategorie("4");
        sitzplatzGame4.setBereich("40");
        sitzplatzGame4.setSitz("133");
        List<RBLSitzplatz> sitzeGame4 = new ArrayList<>();
        sitzeGame4.add(sitzplatzGame4);
        gameWithB4.setPlaetze(sitzeGame4);


        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);
        games.add(gameWithB2);
        games.add(gameWithB3);
        games.add(gameWithB4);

        subject.checkRBLGameList(games);
        Assert.assertEquals("Body not correct", "RB Leipzig - Barca\n" +
                "toller Link\n" +
                "Bereich: 28 Reihe: 2 Sitz: 10\n" +
                "\n" +
                "\n" +
                " RB Leipzig - Deutschland\n" +
                "toller Link 2\n" +
                "Bereich: 30 Reihe: 4 Sitz: 133", subject.getBodyText().trim());
        Assert.assertEquals("Header not correct","RB Leipzig - Barca RB Leipzig - Deutschland ", subject.getHeaderText());
        Assert.assertTrue("Length of List to Save not correct",subject.getGamesToSave().size() == 4);

        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;
        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);

        RBLSitzplatz[] sitzplaetze2 = new RBLSitzplatz[1];
        sitzplaetze2[0] = sitzplatzGame2;
        checkGames(gameName2, link2, (RBLGames)subject.getGamesToSave().toArray()[1], sitzplaetze2);

        RBLSitzplatz[] sitzplaetze3 = new RBLSitzplatz[1];
        sitzplaetze3[0] = sitzplatzGame3;
        checkGames(gameName3, link3, (RBLGames)subject.getGamesToSave().toArray()[2], sitzplaetze3);

        RBLSitzplatz[] sitzplaetze4 = new RBLSitzplatz[1];
        sitzplaetze4[0] = sitzplatzGame4;
        checkGames(gameName4, link4, (RBLGames)subject.getGamesToSave().toArray()[3], sitzplaetze4);
    }

    //@Test
    public void checkWithOneGameWithBBlockButTheGameIsOnIgnoreListHeaderAndBodyMustBeEmptyGameListMustContainTheGame() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";

        RblGameChecker subject = new RblGameChecker();
        subject.addSearchOption(new RblGameSearchOption(gameName));
        subject.reset();
        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("28");
        sitzplatz.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);

        subject.checkRBLGameList(games);
        Assert.assertTrue(subject.getBodyText().isEmpty());
        Assert.assertTrue(subject.getHeaderText().isEmpty());
        Assert.assertTrue(subject.getGamesToSave().size() ==1);
        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }

    //@Test
    public void checkWithTwoGamesWithBBlockOneIsOnIgnoreListHeaderMustContainNameAndBodyMustContainPlatzGameListMustContainOnlyOneGame() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";
        String gameName2 = "RB Leipzig - Deutschland";
        String link2 = "toller Link 2";
        RblGameChecker subject = new RblGameChecker();
        RblGameSearchOption optionB = new RblGameSearchOption("RB Leipzig - Barca");
        optionB.addRule(new RBLRuleSektorB());
        RblGameSearchOption optionD = new RblGameSearchOption("RB Leipzig - Deutschland");
        optionD.addRule(new RBLRuleSektorB());
        subject.reset();
        subject.addSearchOption(optionB);
        subject.addSearchOption(optionD);


        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("28");
        sitzplatz.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        RBLGames gameWithB2 = new RBLGames();
        gameWithB2.setName(gameName2);
        gameWithB2.setLink(link2);
        RBLSitzplatz sitzplatzGame21 = new RBLSitzplatz();
        sitzplatzGame21.setReihe("4");
        sitzplatzGame21.setKategorie("2");
        sitzplatzGame21.setBereich("28");
        sitzplatzGame21.setSitz("133");
        RBLSitzplatz sitzplatzGame22 = new RBLSitzplatz();
        sitzplatzGame22.setReihe("4");
        sitzplatzGame22.setKategorie("2");
        sitzplatzGame22.setBereich("2");
        sitzplatzGame22.setSitz("133");
        RBLSitzplatz sitzplatzGame23 = new RBLSitzplatz();
        sitzplatzGame23.setReihe("4");
        sitzplatzGame23.setKategorie("2");
        sitzplatzGame23.setBereich("30");
        sitzplatzGame23.setSitz("133");
        RBLSitzplatz sitzplatzGame24 = new RBLSitzplatz();
        sitzplatzGame24.setReihe("4");
        sitzplatzGame24.setKategorie("2");
        sitzplatzGame24.setBereich("1");
        sitzplatzGame24.setSitz("133");
        List<RBLSitzplatz> sitzeGame2 = new ArrayList<>();
        sitzeGame2.add(sitzplatzGame21);
        sitzeGame2.add(sitzplatzGame22);
        sitzeGame2.add(sitzplatzGame23);
        sitzeGame2.add(sitzplatzGame24);
        gameWithB2.setPlaetze(sitzeGame2);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);
        games.add(gameWithB2);

        subject.checkRBLGameList(games);
        Assert.assertEquals("Body not correct", "RB Leipzig - Deutschland\n" +
                "toller Link 2\n" +
                "Bereich: 28 Reihe: 4 Sitz: 133\n"+
                "Bereich: 30 Reihe: 4 Sitz: 133", subject.getBodyText().trim());
        Assert.assertEquals("Header not correct","RB Leipzig - Deutschland ", subject.getHeaderText());
        Assert.assertTrue("Length of List to Save not correct",subject.getGamesToSave().size() == 2);

        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }

    //@Test
    public void checkWithOneGameWithDBlockButTheGameIsOnIgnoreListHeaderAndBodyMustBeEmptyGameListMustContainTheGame() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";

        RblGameChecker subject = new RblGameChecker();
        RblGameSearchOption optionB = new RblGameSearchOption("RB Leipzig - Barca");
        optionB.addRule(new RBLRuleSektorB());
        RblGameSearchOption optionD = new RblGameSearchOption("RB Leipzig - Deutschland");
        optionD.addRule(new RBLRuleSektorB());
        subject.reset();
        subject.addSearchOption(optionB);
        subject.addSearchOption(optionD);

        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("55");
        sitzplatz.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        gameWithoutB.setPlaetze(sitze);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);

        subject.checkRBLGameList(games);
        Assert.assertTrue(subject.getBodyText().isEmpty());
        Assert.assertTrue(subject.getHeaderText().isEmpty());
        Assert.assertTrue(subject.getGamesToSave().size() ==1);

        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[1];
        sitzplaetze[0] = sitzplatz;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }

    //@Test
    public void checkWithOneGameWithDAndBBlockButTheGameIsOnIgnoreListHeaderAndBodyMustBeEmptyGameListMustContainTheGame() {
        String gameName = "RB Leipzig - Barca";
        String link = "toller Link";

        RblGameChecker subject = new RblGameChecker();
        subject.addSearchOption(new RblGameSearchOption(gameName));
        subject.reset();
        RBLGames gameWithoutB = new RBLGames();
        gameWithoutB.setName(gameName);
        gameWithoutB.setLink(link);
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setReihe("2");
        sitzplatz.setKategorie("3");
        sitzplatz.setBereich("55");
        sitzplatz.setSitz("10");
        RBLSitzplatz sitzplatzB = new RBLSitzplatz();
        sitzplatzB.setReihe("2");
        sitzplatzB.setKategorie("3");
        sitzplatzB.setBereich("30");
        sitzplatzB.setSitz("10");
        List<RBLSitzplatz> sitze = new ArrayList<>();
        sitze.add(sitzplatz);
        sitze.add(sitzplatzB);
        gameWithoutB.setPlaetze(sitze);

        List<RBLGames> games = new ArrayList<>();
        games.add(gameWithoutB);

        subject.checkRBLGameList(games);
        Assert.assertTrue(subject.getBodyText().isEmpty());
        Assert.assertTrue(subject.getHeaderText().isEmpty());
        Assert.assertTrue(subject.getGamesToSave().size() == 1);

        RBLSitzplatz[] sitzplaetze = new RBLSitzplatz[2];
        sitzplaetze[0] = sitzplatz;
        sitzplaetze[1] = sitzplatzB;

        checkGames(gameName, link, (RBLGames)subject.getGamesToSave().toArray()[0], sitzplaetze);
    }

    private void checkGames(String gameName, String link,  RBLGames game, RBLSitzplatz[] sitzplatz) {
        Assert.assertEquals(game.getName(), gameName);
        Assert.assertEquals(game.getLink(), link);
        Assert.assertTrue(game.getPlaetze().size() == sitzplatz.length);
        int i = 0;
        for (Iterator<RBLSitzplatz> its = game.getPlaetze().iterator(); its.hasNext(); ) {
            RBLSitzplatz platz = its.next();
            Assert.assertEquals(platz.getBereich(), sitzplatz[i].getBereich());
            Assert.assertEquals(platz.getReihe(), sitzplatz[i].getReihe());
            Assert.assertEquals(platz.getSitz(), sitzplatz[i].getSitz());
            Assert.assertEquals(platz.getKategorie(), sitzplatz[i].getKategorie());
            i++;
        }
    }
}
