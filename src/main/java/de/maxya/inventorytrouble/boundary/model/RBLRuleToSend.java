package de.maxya.inventorytrouble.boundary.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RBLRuleToSend {

    private int id;

    private String name;

    public RBLRuleToSend() {
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonSetter
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }
}
