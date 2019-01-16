package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class WebSocketMessageSenderTests {

    private WebSocketMessageSender subject = new WebSocketMessageSender(null,null);

    @Test
    public void testdistinctWithEmptyList() {
        //arrange
        subject.setFindings(new ArrayList<>());

        //act
        subject.distinct();
        List<RBLRuleResult> actual = subject.elementsToSend;

        //assert
        Assert.assertTrue(0 == actual.size());
    }

    @Test
    public void testdistinctWith2istItemsWithSameName() {
        //arrange
        List<RBLRuleResult> list = new ArrayList<>();
        RBLRuleResult rbl = new RBLRuleResult();
        rbl.Name = "RB Leipzig - SC Münchaurach";
        RBLRuleResult rbl1 = new RBLRuleResult();
        rbl1.Name = "RB Leipzig - SC Münchaurach";
        list.add(rbl);
        list.add(rbl1);

        subject.setFindings(list);

        //act
        subject.distinct();
        List<RBLRuleResult> actual = subject.elementsToSend;

        //assert
        Assert.assertTrue(1 == actual.size());
    }


    @Test
    public void testdistinctWith2istItemsWithSameNameAndOneWithAnother() {
        //arrange
        List<RBLRuleResult> list = new ArrayList<>();
        RBLRuleResult rbl = new RBLRuleResult();
        rbl.Name = "RB Leipzig - SC Münchaurach";
        RBLRuleResult rbl1 = new RBLRuleResult();
        rbl1.Name = "RB Leipzig - SC Münchaurach";
        RBLRuleResult rbl2 = new RBLRuleResult();
        rbl2.Name = "RB Leipzig - Zickenkickers";
        list.add(rbl);
        list.add(rbl1);
        list.add(rbl2);

        subject.setFindings(list);

        //act
        subject.distinct();
        List<RBLRuleResult> actual = subject.elementsToSend;

        //assert
        Assert.assertTrue(2 == actual.size());
    }
}
