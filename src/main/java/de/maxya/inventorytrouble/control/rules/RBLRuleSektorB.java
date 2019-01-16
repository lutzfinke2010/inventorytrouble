package de.maxya.inventorytrouble.control.rules;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.schedule.RBLRule;

public class RBLRuleSektorB implements RBLRule {
    @Override
    public boolean check(RBLSitzplatz rblPlatz) {
        try {
            int bereich = Integer.parseInt(rblPlatz.getBereich());
            if (bereich >= 25 && bereich <= 31) {
                return true;
            }
            return false;
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "Sektor B";
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
