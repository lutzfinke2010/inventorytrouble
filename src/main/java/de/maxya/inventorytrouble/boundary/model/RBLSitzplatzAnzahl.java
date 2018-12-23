package de.maxya.inventorytrouble.boundary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;

public class RBLSitzplatzAnzahl {

    private Date zeitpunkt;
    private int count;
    private int countBBlock;

    @JsonProperty("zeitpunkt")
    public Date getZeitpunkt() {
        return zeitpunkt;
    }

    @JsonSetter
    public void setZeitpunkt(Date zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    @JsonSetter
    public void setCount(int count) {
        this.count = count;
    }

    @JsonProperty("countBBlock")
    public int getCountBBlock() {
        return countBBlock;
    }

    @JsonSetter
    public void setCountBBlock(int countBBlock) {
        this.countBBlock = countBBlock;
    }


}
