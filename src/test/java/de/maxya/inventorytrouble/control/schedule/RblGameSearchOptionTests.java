package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.InventorytroubleApplicationConfig;
import de.maxya.inventorytrouble.boundary.model.RBLGameToSearch;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorA;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorB;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorC;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorD;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = InventorytroubleApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class RblGameSearchOptionTests {


    @Test
    public void test_constructor_containsEmptyList() {
        RblGameSearchOption subject = new RblGameSearchOption("RB Leipzig-Hertha BSC");
        Assert.assertEquals(subject.getRules().size(), 0);
    }

    @Test
    public void test_containsRule_emptyList_returnsfalse() {
        RblGameSearchOption subject = new RblGameSearchOption("RB Leipzig-Hertha BSC");
        boolean actual = subject.containsRule("neue Rule");
        Assert.assertEquals(false, actual);
    }

    @Test
    public void test_containsRule_listContainsSektorAAskSektorB_returnsfalse() {
        RblGameSearchOption subject = new RblGameSearchOption("RB Leipzig-Hertha BSC");
        subject.addRule(new RBLRuleSektorA());
        boolean actual = subject.containsRule("Sektor B");
        Assert.assertEquals(false, actual);
    }

    @Test
    public void test_containsRule_listContainsSektorAAskSektorA_returnsfalse() {
        RblGameSearchOption subject = new RblGameSearchOption("RB Leipzig-Hertha BSC");
        subject.addRule(new RBLRuleSektorA());
        boolean actual = subject.containsRule("Sektor A");
        Assert.assertEquals(true, actual);
    }

    @Test
    public void test_containsRule_listContainsAllSektorsAskSektorB_returnsfalse() {
        RblGameSearchOption subject = new RblGameSearchOption("RB Leipzig-Hertha BSC");
        subject.addRule(new RBLRuleSektorA());
        subject.addRule(new RBLRuleSektorB());
        subject.addRule(new RBLRuleSektorC());
        subject.addRule(new RBLRuleSektorD());
        boolean actual = subject.containsRule("Sektor B");
        Assert.assertEquals(true, actual);
    }

}
