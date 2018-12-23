package de.maxya.inventorytrouble.boundary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RBLSitzplatz {

    private Long id;
    private String bereich;
    private String reihe;
    private String sitz;
    private String kategorie;

    @JsonProperty("sitz")
    public String getSitz() {
        return sitz;
    }

    @JsonSetter
    public void setSitz(String sitz) {
        this.sitz = sitz;
    }

    @JsonProperty("kategorie")
    public String getKategorie() {
        return kategorie;
    }

    @JsonSetter
    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    @JsonProperty("reihe")
    public String getReihe() {
        return reihe;
    }

    @JsonSetter
    public void setReihe(String reihe) {
        this.reihe = reihe;
    }

    @JsonProperty("bereich")
    public String getBereich() {
        return bereich;
    }

    @JsonSetter
    public void setBereich(String bereich) {
        this.bereich = bereich;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonSetter
    public void setId(Long id) {
        this.id = id;
    }

    public int getBereichAsInt() {
        return Integer.parseInt(getBereich());
    }

    public int getSitzAsInt() {
        return Integer.parseInt(getSitz());
    }

    public int getReiheAsInt() {
        return Integer.parseInt(getReihe());
    }

    public String toString() {
        return getKategorie() + " " + getBereich() + " " + getReihe() + " " + getSitz() + " " + getSortNumber();
    }

    public int getSortNumber() {
        try {
            int bereich = getBereichAsInt();
            int reihe = getReiheAsInt();
            int sitz = getSitzAsInt();
            //BBRRSS
            return (bereich * 10000) + (reihe * 100) + sitz;
        } catch (NumberFormatException ex) {
            //System.out.println("NumberFormatException: " + toString());
            return -1;
        }
    }

    public static RBLSitzplatz createPlace(String kategorie, int bereich, int reihe, int sitz ){
        RBLSitzplatz platz = new RBLSitzplatz();
        platz.setKategorie(kategorie);
        platz.setBereich(""+bereich);
        platz.setReihe(""+reihe);
        platz.setSitz(""+sitz);
        return platz;
    }
}
