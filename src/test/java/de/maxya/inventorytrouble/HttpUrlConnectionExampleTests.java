package de.maxya.inventorytrouble;


import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.login.HttpUrlConnectionExample;
import de.maxya.inventorytrouble.control.login.WarteRaumException;
import org.assertj.core.api.StringAssert;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HttpUrlConnectionExampleTests {

    @Test
    public void test_getSortNumber_when_PlatzIsEmpty_expect_lowerZero(){
        //arrange
        HttpUrlConnectionExample example = new HttpUrlConnectionExample();
        String actual = "";
        //act
        try {
            actual = example.login();
            Assert.assertTrue(actual.contains("Müller"));
        } catch (WarteRaumException e) {
            System.out.println("Warteraum");
            Assert.assertFalse(true);
        } catch( Exception e){
            System.out.println("Sonstiges");
            Assert.assertTrue(false);
        }

        //assert
        Assert.assertEquals(1,1);
    }
}
