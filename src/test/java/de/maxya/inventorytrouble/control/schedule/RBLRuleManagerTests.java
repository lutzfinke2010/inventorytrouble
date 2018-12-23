package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.InventorytroubleApplicationConfig;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rblparser.RBLPageParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = InventorytroubleApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
//@SpringBootTest
public class RBLRuleManagerTests {

    RBLRulesManager subject = new RBLRulesManager();

    //@Test
    public void noRuleExistsReturnFalse(){
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("23");
        Assert.assertFalse(subject.check(createGameWithPlace(sitzplatz), new RBLGameSearchOption("")).stream().findFirst().get().Check);
    }

    private RBLGames createGameWithPlace(RBLSitzplatz sitzplatz){
        RBLGames game = new RBLGames();
        List<RBLSitzplatz> plaetze = new ArrayList<>();
        plaetze.add(sitzplatz);
        game.setPlaetze(plaetze);
        return game;
    }

    //@Test
    public void oneRuleExistsSitzplatzInRuleReturnTrue(){
        RBLRuleSektorB ruleSektorB = new RBLRuleSektorB();
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("28");
        Assert.assertTrue(subject.check(createGameWithPlace(sitzplatz), new RBLGameSearchOption("")).stream().findFirst().get().Check);
        Assert.assertEquals(subject.check(createGameWithPlace(sitzplatz), new RBLGameSearchOption("")).stream().findFirst().get().Info, "Sektor B");
    }

    //@Test
    public void twoRulesExistsSitzplatzInRule2ReturnTrue(){
        RBLRuleSektorD ruleSektorD = new RBLRuleSektorD();
        RBLRuleSektorB ruleSektorB = new RBLRuleSektorB();
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("28");
        Assert.assertTrue(subject.check(createGameWithPlace(sitzplatz), new RBLGameSearchOption("")).stream().findFirst().get().Check);
        Assert.assertEquals(subject.check(createGameWithPlace(sitzplatz), new RBLGameSearchOption("")).stream().findFirst().get().Info, "Sektor B");
    }

    //@Test
    public void twoRulesExistsSitzplatzInNoRule2ReturnFalse(){
        RBLRuleSektorD ruleSektorD = new RBLRuleSektorD();
        RBLRuleSektorB ruleSektorB = new RBLRuleSektorB();
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("100");
        Assert.assertFalse(subject.check(createGameWithPlace(sitzplatz), new RBLGameSearchOption("")).stream().findFirst().get().Check);
    }

}
