package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;

public class RBLRuleSektorD implements RBLRule {
    @Override
    public boolean check(RBLSitzplatz rblPlatz) {
        try {
            int bereich = Integer.parseInt(rblPlatz.getBereich());
            if (bereich >= 54 && bereich <= 60) {
                return true;
            }
            return false;
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    boolean searchNeighbours = false;

    @Override
    public boolean shouldSearchNeighbours() {
        return searchNeighbours;
    }

    public void searchNeighbours(boolean search){
        this.searchNeighbours = search;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Sektor D " + (searchNeighbours ? " nur Nachbarn" : " only");
    }
}
