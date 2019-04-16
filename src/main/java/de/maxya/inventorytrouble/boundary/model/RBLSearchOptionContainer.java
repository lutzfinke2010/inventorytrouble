package de.maxya.inventorytrouble.boundary.model;

import de.maxya.inventorytrouble.control.schedule.RblGameSearchOption;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RBLSearchOptionContainer {
    private List<RblGameSearchOption> searchOptions;
    private List<RBLGames> scanedGames;
    private Date date;

    public RBLSearchOptionContainer(){
        searchOptions = new ArrayList<>();
        scanedGames = new ArrayList<>();
    }

    public List<RblGameSearchOption> getSearchOptions() {
        return searchOptions;
    }

    public void setSearchOptions(List<RblGameSearchOption> searchOptions) {
        this.searchOptions = searchOptions;
    }

    public List<RBLGames> getScanedGames() {
        return scanedGames;
    }

    public void setScanedGames(List<RBLGames> scanedGames) {
        this.scanedGames = scanedGames;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
