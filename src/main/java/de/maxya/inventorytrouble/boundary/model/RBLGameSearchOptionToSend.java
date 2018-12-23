package de.maxya.inventorytrouble.boundary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class RBLGameSearchOptionToSend {
    private String name;
    private List<RBLRuleToSend> rules;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("rules")
    public List<RBLRuleToSend> getRules() {
        return rules;
    }

    @JsonSetter
    public void setRules(List<RBLRuleToSend> rules) {
        this.rules = rules;
    }
}
