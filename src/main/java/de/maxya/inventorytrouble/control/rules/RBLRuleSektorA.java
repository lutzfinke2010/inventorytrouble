package de.maxya.inventorytrouble.control.rules;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.schedule.RBLRule;

public class RBLRuleSektorA implements RBLRule {
    @Override
    public boolean check(RBLSitzplatz rblPlatz) {
        try {
            int bereich = Integer.parseInt(rblPlatz.getBereich());
            if (bereich >= 1 && bereich <= 24) {
                return true;
            }
            return false;
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getName() {
        return "Sektor A";
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
