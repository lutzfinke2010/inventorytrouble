package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RBLSitzplatzTests {

    @Test
    public void test_getSortNumber_when_PlatzIsEmpty_expect_lowerZero(){
        //arrange
        RBLSitzplatz platz = new RBLSitzplatz();

        //act
        int actual = platz.getSortNumber();

        //assert
        Assert.assertEquals(-1,actual);
    }

    @Test
    public void test_getSortNumber_when_PlatzContainCorrectSeatWithoutLetters_expect_CorrectNumber(){
        //arrange
        RBLSitzplatz platz = new RBLSitzplatz();
        platz.setBereich("28");
        platz.setReihe("10");
        platz.setSitz("5");

        //act1
        int actual = platz.getSortNumber();

        //assert
        Assert.assertEquals(281005,actual);
    }

    @Test
    public void test_getSortNumber_when_PlatzContainCorrectSeatWithLetters_expect_LowerZero(){
        //arrange
        RBLSitzplatz platz = new RBLSitzplatz();
        platz.setBereich("28");
        platz.setReihe("10");
        platz.setSitz("5R");

        //act1
        int actual = platz.getSortNumber();

        //assert
        Assert.assertEquals(-1,actual);
    }

    @Test
    public void test_getSortNumber_when_PlatzContainCorrectSeatWithLettersInRow_expect_LowerZero(){
        //arrange
        RBLSitzplatz platz = new RBLSitzplatz();
        platz.setBereich("28");
        platz.setReihe("10R");
        platz.setSitz("5");

        //act1
        int actual = platz.getSortNumber();

        //assert
        Assert.assertEquals(-1,actual);
    }

    @Test
    public void test_getSortNumber_when_PlatzContainCorrectSeatWithLettersInBlock_expect_LowerZero(){
        //arrange
        RBLSitzplatz platz = new RBLSitzplatz();
        platz.setBereich("28R");
        platz.setReihe("10");
        platz.setSitz("5");

        //act1
        int actual = platz.getSortNumber();

        //assert
        Assert.assertTrue(actual < 0);
    }
}
