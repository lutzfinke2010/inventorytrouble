package de.maxya.inventorytrouble;


import de.maxya.inventorytrouble.control.login.HtmlUnitExample;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class HtmlUnitExampleTests {

    @Test
    public void test_getSortNumber_when_PlatzIsEmpty_expect_lowerZero() throws IOException {
        //arrange
        HtmlUnitExample ex = new HtmlUnitExample();

        //act
        String actual = ex.login();
        System.out.println("PageContent:" + actual);
        Assert.assertTrue(actual.contains("Müller"));

        //assert
        Assert.assertEquals(1, 1);
    }
}
