package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;

public class RBLRuleSektorC implements RBLRule {
    @Override
    public boolean check(RBLSitzplatz rblPlatz) {
        try {
            int bereich = Integer.parseInt(rblPlatz.getBereich());
            if (bereich >= 32 && bereich <= 50) {
                return true;
            }
            return false;
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String getName() {
        return "Sektor C";
    }


    boolean searchNeighbours = false;

    @Override
    public boolean shouldSearchNeighbours() {
        return searchNeighbours;
    }

    public void searchNeighbours(boolean search){
        this.searchNeighbours = search;
    }
}
