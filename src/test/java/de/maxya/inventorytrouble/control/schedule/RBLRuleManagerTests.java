package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorB;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorD;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = InventorytroubleApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
//@SpringBootTest
public class RBLRuleManagerTests {

    RBLRulesManager subject = new RBLRulesManager();

    //@Test
    public void noRuleExistsReturnFalse(){
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("23");
        Assert.assertFalse(subject.check(createGameWithPlace(sitzplatz), new RblGameSearchOption("")).stream().findFirst().get().Check);
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
        Assert.assertTrue(subject.check(createGameWithPlace(sitzplatz), new RblGameSearchOption("")).stream().findFirst().get().Check);
        Assert.assertEquals(subject.check(createGameWithPlace(sitzplatz), new RblGameSearchOption("")).stream().findFirst().get().Info, "Sektor B");
    }

    //@Test
    public void twoRulesExistsSitzplatzInRule2ReturnTrue(){
        RBLRuleSektorD ruleSektorD = new RBLRuleSektorD();
        RBLRuleSektorB ruleSektorB = new RBLRuleSektorB();
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("28");
        Assert.assertTrue(subject.check(createGameWithPlace(sitzplatz), new RblGameSearchOption("")).stream().findFirst().get().Check);
        Assert.assertEquals(subject.check(createGameWithPlace(sitzplatz), new RblGameSearchOption("")).stream().findFirst().get().Info, "Sektor B");
    }

    //@Test
    public void twoRulesExistsSitzplatzInNoRule2ReturnFalse(){
        RBLRuleSektorD ruleSektorD = new RBLRuleSektorD();
        RBLRuleSektorB ruleSektorB = new RBLRuleSektorB();
        RBLSitzplatz sitzplatz = new RBLSitzplatz();
        sitzplatz.setBereich("100");
        Assert.assertFalse(subject.check(createGameWithPlace(sitzplatz), new RblGameSearchOption("")).stream().findFirst().get().Check);
    }

}
