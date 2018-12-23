package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RBLSitzplatzComparerTests {

    @Test
    public void sameSitzExpectTrue() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setKategorie("D");
        platz1.setBereich("34");
        platz1.setReihe("4");
        platz1.setSitz("3");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertEquals(0, subject.compare(platz1,platz1));
    }

    @Test
    public void place2IsHigherExpectLowerZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setKategorie("D");
        platz1.setBereich("34");
        platz1.setReihe("4");
        platz1.setSitz("3");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setKategorie("D");
        platz2.setBereich("34");
        platz2.setReihe("4");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertEquals(true, subject.compare(platz1,platz2)< 0);
    }

    @Test
    public void place1IsHigherExpectHigherZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("34");
        platz1.setReihe("4");
        platz1.setSitz("33");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("34");
        platz2.setReihe("4");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertEquals(true, subject.compare(platz1,platz2) > 0);
    }


    @Test
    public void seatIsTheSameSecondRowIsHigherExpectLowerZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("34");
        platz1.setReihe("4");
        platz1.setSitz("6");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("34");
        platz2.setReihe("5");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertTrue(subject.compare(platz1,platz2) < 0);
    }

    @Test
    public void seatAndRowAreTheSameSecondBlockIsHigherExpectLowerZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("34");
        platz1.setReihe("4");
        platz1.setSitz("6");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("40");
        platz2.setReihe("4");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertTrue(subject.compare(platz1,platz2) < 0);
    }



    @Test
    public void firstSeatContainsALetterExpectLowerZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("34");
        platz1.setReihe("4R");
        platz1.setSitz("6");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("40");
        platz2.setReihe("4");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertTrue(subject.compare(platz1,platz2) < 0);
    }

    @Test
    public void secondSeatContainsALetterExpectGreaterZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("34");
        platz1.setReihe("4");
        platz1.setSitz("6");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("40");
        platz2.setReihe("4R");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertTrue(subject.compare(platz1,platz2) > 0);
    }

    @Test
    public void bothSeatsContainsALetterExpectZero() {
        RBLSitzplatz platz1 = new RBLSitzplatz();
        platz1.setBereich("34");
        platz1.setReihe("4S");
        platz1.setSitz("6");
        RBLSitzplatz platz2 = new RBLSitzplatz();
        platz2.setBereich("40");
        platz2.setReihe("4R");
        platz2.setSitz("6");

        RBLSitzplatzComparer subject = new RBLSitzplatzComparer();

        Assert.assertTrue(subject.compare(platz1,platz2) == 0);
    }

}
