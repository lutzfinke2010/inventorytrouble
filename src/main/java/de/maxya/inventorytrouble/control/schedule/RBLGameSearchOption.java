package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLRuleToSend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RBLGameSearchOption {

    private List<RBLRule> rules;
    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);

    public RBLGameSearchOption(String name) {
        this.name = name;
        this.rules = new ArrayList<>();
    }

    public void log() {
        LOGGER.info("Name: " + name);
        for (Iterator<RBLRule> it = this.rules.iterator(); it.hasNext(); ) {
            RBLRule rule = it.next();
            LOGGER.info("Rule: " + rule.getName());
        }
    }

    public String name;

    public void addRule(RBLRule rule) {
        this.rules.add(rule);
    }

    public List<RBLRule> getRules() {
        return rules;
    }

    public void setRules(List<RBLRule> rules) {
        this.rules = rules;
    }
}
