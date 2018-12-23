package de.maxya.inventorytrouble.control.mapper;

import de.maxya.inventorytrouble.boundary.model.RBLGameSearchOptionToSend;
import de.maxya.inventorytrouble.boundary.model.RBLRuleToSend;
import de.maxya.inventorytrouble.control.schedule.RBLGameSearchOption;
import de.maxya.inventorytrouble.control.schedule.RBLRuleSektorB;
import de.maxya.inventorytrouble.control.schedule.RBLRuleSektorD;

import java.util.Iterator;

public class RBLGameSearchOptionMapper {
    public static RBLGameSearchOption mapToRBLGameSearchOption(RBLGameSearchOptionToSend gameSearchOption) {
        if (null == gameSearchOption) {
            return null;
        }
        RBLGameSearchOption gameEnt = new RBLGameSearchOption(gameSearchOption.getName());
        gameEnt.name = (gameSearchOption.getName());
        for (Iterator<RBLRuleToSend> it = gameSearchOption.getRules().iterator(); it.hasNext(); ) {
            RBLRuleToSend rule = it.next();
            switch (rule.getId()){
                case(0):{
                    gameEnt.addRule(new RBLRuleSektorB());
                    break;
                }
                case(1):{
                    gameEnt.addRule(new RBLRuleSektorD());
                    break;
                }
            }
        }
        return gameEnt;
    }

}
