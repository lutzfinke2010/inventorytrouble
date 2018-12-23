package de.maxya.inventorytrouble.boundary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RBLSitzplatzAnzahlVerlauf {

    private String name;
    private List<RBLSitzplatzAnzahl> plaetze;
    private Date startDate;


    @JsonProperty("startdate")
    public Date getStartDate() {
        return startDate;
    }

    @JsonSetter
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }


    @JsonProperty("plaetze")
    public List<RBLSitzplatzAnzahl> getPlaetze() {
        if (plaetze == null){
            plaetze = new ArrayList<>();
        }
        return plaetze;
    }

    @JsonSetter
    public void setPlaetze(List<RBLSitzplatzAnzahl> plaetze) {
        this.plaetze = plaetze;
    }

    @Override
    public String toString() {
        String erg = "";
        erg += this.getName() + "\n";
        for (Iterator<RBLSitzplatzAnzahl> it = this.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatzAnzahl platz = it.next();
            erg += "Zeitpunkt: " + platz.getZeitpunkt() + " Count: " + platz.getCount() + " Count B: " + platz.getCountBBlock() + "\n";
        }
        return erg;
    }
}
