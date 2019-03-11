package de.maxya.inventorytrouble.boundary.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RBLGameToSearch {

    private String name;
    private String sektor;
    private boolean aktiv;

    public RBLGameToSearch() {
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("aktiv")
    public boolean isAktiv() {
        return aktiv;
    }

    @JsonSetter
    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    @JsonProperty("sektor")
    public String getSektor() {
        return sektor;
    }

    @JsonSetter
    public void setSektor(String sektor) {
        this.sektor = sektor;
    }

}
