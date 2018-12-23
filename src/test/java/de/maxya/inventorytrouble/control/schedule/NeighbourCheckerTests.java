package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NeighbourCheckerTests {

    @Test
    public void placesAreEmptyExpectFalse() {
        NeighbourChecker subject = new NeighbourChecker();
        RBLGames game = new RBLGames();
        RBLGameSearchOption option = new RBLGameSearchOption("game");

        RBLRuleResult actual = subject.check(game, option, new RBLRuleSektorD());

        Assert.assertEquals(false,actual.Check);
    }

    @Test
    public void placesContains1NeightbourPlacesExpectFalse() {
        NeighbourChecker subject = new NeighbourChecker();
        RBLGames game = new RBLGames();
        List<RBLSitzplatz> plaetze = new ArrayList<RBLSitzplatz>();
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("D");
        platz1.setReihe("4");
        platz1.setSitz("3");

        plaetze.add(platz1);

        game.setPlaetze(plaetze);

        RBLGameSearchOption option = new RBLGameSearchOption("game");

        RBLRuleResult actual = subject.check(game, option, new RBLRuleSektorD());

        Assert.assertEquals(false,actual.Check);
    }


    @Test
    public void placesContains2NeightbourPlacesExpectTrue() {
        NeighbourChecker subject = new NeighbourChecker();
        RBLGames game = new RBLGames();
        List<RBLSitzplatz> plaetze = new ArrayList<RBLSitzplatz>();
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("58");
        platz1.setReihe("4");
        platz1.setSitz("3");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("58");
        platz2.setReihe("4");
        platz2.setSitz("4");

        plaetze.add(platz1);
        plaetze.add(platz2);

        game.setPlaetze(plaetze);

        RBLGameSearchOption option = new RBLGameSearchOption("game");

        RBLRuleResult actual = subject.check(game, option, new RBLRuleSektorD());

        Assert.assertEquals(true,actual.Check);
    }

    @Test
    public void placesContains3Places02NeightbourPlacesExpectTrue() {
        NeighbourChecker subject = new NeighbourChecker();
        RBLGames game = new RBLGames();
        List<RBLSitzplatz> plaetze = new ArrayList<RBLSitzplatz>();
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("55");
        platz1.setReihe("4");
        platz1.setSitz("4");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("55");
        platz2.setReihe("4");
        platz2.setSitz("46");
        RBLSitzplatz platz3 = new RBLSitzplatz();
        platz3.setBereich("55");
        platz3.setReihe("4");
        platz3.setSitz("3");

        plaetze.add(platz1);
        plaetze.add(platz2);
        plaetze.add(platz3);

        game.setPlaetze(plaetze);

        RBLGameSearchOption option = new RBLGameSearchOption("game");

        RBLRuleResult actual = subject.check(game, option, new RBLRuleSektorD());

        Assert.assertEquals(true,actual.Check);
    }



    @Test
    public void placesContains2PlaetzeNebeneinanderAberInAnderernReihenErwarteFalse() {
        NeighbourChecker subject = new NeighbourChecker();
        RBLGames game = new RBLGames();
        List<RBLSitzplatz> plaetze = new ArrayList<RBLSitzplatz>();
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("23");
        platz1.setReihe("4");
        platz1.setSitz("3");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("23");
        platz2.setReihe("5");
        platz2.setSitz("4");

        game.setPlaetze(plaetze);

        RBLGameSearchOption option = new RBLGameSearchOption("game");

        RBLRuleResult actual = subject.check(game, option, new RBLRuleSektorD());

        Assert.assertEquals(false,actual.Check);
    }


    @Test
    public void placesContains2PlaetzeNebeneinanderUnd10AndereErwarteTrue() {
        NeighbourChecker subject = new NeighbourChecker();
        RBLGames game = new RBLGames();
        List<RBLSitzplatz> plaetze = new ArrayList<RBLSitzplatz>();

        plaetze.add(RBLSitzplatz.createPlace("D", 55,4,3));
        plaetze.add(RBLSitzplatz.createPlace("D", 56,5,3));
        plaetze.add(RBLSitzplatz.createPlace("D", 55,5,3));
        plaetze.add(RBLSitzplatz.createPlace("B", 11,5,3));
        plaetze.add(RBLSitzplatz.createPlace("D", 3,5,3));
        plaetze.add(RBLSitzplatz.createPlace("C", 23,6,2));
        plaetze.add(RBLSitzplatz.createPlace("D", 55,4,4));
        plaetze.add(RBLSitzplatz.createPlace("A", 11,6,3));
        plaetze.add(RBLSitzplatz.createPlace("D", 22,5,3));
        plaetze.add(RBLSitzplatz.createPlace("D", 24,5,3));
        plaetze.add(RBLSitzplatz.createPlace("D", 25,3,5));
        plaetze.add(RBLSitzplatz.createPlace("D", 26,5,6));
        plaetze.add(RBLSitzplatz.createPlace("D", 27,6,7));
        plaetze.add(RBLSitzplatz.createPlace("D", 28,5,8));


        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("23");
        platz2.setReihe("5R");
        platz2.setSitz("4");

        plaetze.add(platz2);

        game.setPlaetze(plaetze);

        RBLGameSearchOption option = new RBLGameSearchOption("game");

        RBLRuleResult actual = subject.check(game, option, new RBLRuleSektorD());

        System.out.println("Result:" + actual.Info);

        Assert.assertEquals(true,actual.Check);
    }
}
