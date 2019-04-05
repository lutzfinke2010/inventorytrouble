package de.maxya.inventorytrouble.boundary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RBLGames {

    private String name;
    private String link;

    private Date startDate;
    private Long id;
    private List<RBLSitzplatz> plaetze;


    private String gameId;

    public int getCountSitzplaetze() {
        return countSitzplaetze;
    }

    public void setCountSitzplaetze(int countSitzplaetze) {
        this.countSitzplaetze = countSitzplaetze;
    }

    private int countSitzplaetze;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifiedDate) {
        this.modifyDate = modifiedDate;
    }

    private Date createDate;
    private Date modifyDate;

    public RBLGames() {
        plaetze = new ArrayList<>();
    }

    public RBLGames(String name) {
        plaetze = new ArrayList<>();
        this.setName(name);
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonSetter
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonSetter
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("plaetze")
    public List<RBLSitzplatz> getPlaetze() {
        return plaetze;
    }

    @JsonSetter
    public void setPlaetze(List<RBLSitzplatz> plaetze) {
        this.plaetze = plaetze;
    }

    @JsonProperty("startdate")
    public Date getStartDate() {
        return startDate;
    }

    @JsonSetter
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        String erg = "";
        erg += this.getName() + "\n";
        erg += this.getLink() + "\n";
        for (Iterator<RBLSitzplatz> it = this.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz platz = it.next();
            erg += "Bereich: " + platz.getBereich() + " Reihe: " + platz.getReihe() + " Sitz: " + platz.getSitz() + "\n";
        }
        return erg;
    }

    public static boolean isBBLockPlatz(int bereich) {
        if (bereich >= 25 && bereich <= 31) {
            return true;
        }
        return false;
    }

    public static boolean isDBLockPlatz(int bereich) {
        if (bereich >= 54 && bereich <= 60) {
            return true;
        }
        return false;
    }

    public static boolean isBBLockPlatz(RBLSitzplatz platz) {
        try {
            int bereich = Integer.parseInt(platz.getBereich());
            return isBBLockPlatz(bereich);
        } catch (NumberFormatException ex) {
            //kein Sitzplatz in B
        }
        return false;
    }

    public static boolean isDBLockPlatz(RBLSitzplatz platz) {
        try {
            int bereich = Integer.parseInt(platz.getBereich());
            return isDBLockPlatz(bereich);
        } catch (NumberFormatException ex) {
            //kein Sitzplatz in B
        }
        return false;
    }

    public boolean hasBBlockPlaetze() {
        for (Iterator<RBLSitzplatz> itPlaces = getPlaetze().iterator(); itPlaces.hasNext(); ) {
            RBLSitzplatz platz = itPlaces.next();

            if (isBBLockPlatz(platz)) {
                return true;
            }
        }
        return false;
    }

    public int getCountBBLock() {
        int erg = 0;
        for (Iterator<RBLSitzplatz> it = this.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz platz = it.next();
            if (isBBLockPlatz(platz)) {
                erg++;
            }
        }
        return erg;
    }

    public String toStringOnlyB() {
        String erg = "";
        erg += this.getName() + "\n";
        erg += this.getLink() + "\n";
        for (Iterator<RBLSitzplatz> it = this.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz platz = it.next();
            if (isBBLockPlatz(platz)) {
                erg += "Bereich: " + platz.getBereich() + " Reihe: " + platz.getReihe() + " Sitz: " + platz.getSitz() + "\n";
            }
        }
        return erg;
    }

    public String toStringOnlyD() {
        String erg = "";
        erg += this.getName() + "\n";
        erg += this.getLink() + "\n";
        for (Iterator<RBLSitzplatz> it = this.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz platz = it.next();
            if (isDBLockPlatz(platz)) {
                erg += "Bereich: " + platz.getBereich() + " Reihe: " + platz.getReihe() + " Sitz: " + platz.getSitz() + "\n";
            }
        }
        return erg;
    }

    public int getCountDBLock() {
        int erg = 0;
        for (Iterator<RBLSitzplatz> it = this.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz platz = it.next();
            if (isDBLockPlatz(platz)) {
                erg++;
            }
        }
        return erg;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }
}
