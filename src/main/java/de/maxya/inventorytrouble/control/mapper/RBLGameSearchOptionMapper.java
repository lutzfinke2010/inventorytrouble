package de.maxya.inventorytrouble.control.mapper;

import de.maxya.inventorytrouble.boundary.model.RBLGameSearchOptionToSend;
import de.maxya.inventorytrouble.boundary.model.RBLRuleToSend;
import de.maxya.inventorytrouble.control.schedule.RblGameSearchOption;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorB;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorD;

import java.util.Iterator;

public class RBLGameSearchOptionMapper {
    public static RblGameSearchOption mapToRBLGameSearchOption(RBLGameSearchOptionToSend gameSearchOption) {
        if (null == gameSearchOption) {
            return null;
        }
        RblGameSearchOption gameEnt = new RblGameSearchOption(gameSearchOption.getName());
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
