package de.maxya.inventorytrouble;


import de.maxya.inventorytrouble.control.login.RblScannerHtmlUnit;
import de.maxya.inventorytrouble.control.login.UserDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserDataService.class)
@SpringBootTest
public class HtmlUnitExampleTests {

    @Test
    public void test_loadTicketboerse_coontainsMuellerOrBrunner() throws IOException {
        //arrange
        UserDataService userDataService = new UserDataService();
        RblScannerHtmlUnit ex = new RblScannerHtmlUnit();
        ex.setUserDataService(userDataService);

        //act
        ex.refreshLogin();
        String actual = ex.loadTicketboerse();
        System.out.println("PageContent:" + actual);
        Assert.assertTrue(actual.contains("Brunner") || actual.contains("Müller"));

        //assert
        Assert.assertEquals(1, 1);
    }
}
