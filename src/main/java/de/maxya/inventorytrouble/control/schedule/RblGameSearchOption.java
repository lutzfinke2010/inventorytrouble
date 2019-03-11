package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RblGameSearchOption {

    private List<RBLRule> rules;
    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);

    public RblGameSearchOption(String name) {
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

    public void removeRule(String ruleName) {
        this.rules = this.rules.stream().filter(rule -> rule.getName().equals(ruleName) == false).collect(Collectors.toList());
    }

    public boolean containsRule(String ruleName) {
        return this.rules.stream().filter(rule ->rule.getName().equals(ruleName)).findFirst().isPresent();
    }
}
