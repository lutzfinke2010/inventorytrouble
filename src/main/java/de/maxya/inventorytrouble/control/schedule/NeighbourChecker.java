package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;

import java.util.Collections;
import java.util.Iterator;

public class NeighbourChecker extends RBLRuleResult {

    public NeighbourChecker() {
    }

    public RBLRuleResult check(RBLGames game, RblGameSearchOption searchOption, RBLRule rule) {
        RBLRuleResult result = new RBLRuleResult();
        result.Check = false;
        result.link = game.getLink();

        Collections.sort(game.getPlaetze(), new RBLSitzplatzComparer());
        RBLSitzplatz lastPlace = null;

        for (Iterator<RBLSitzplatz> itPlaces =game.getPlaetze().iterator(); itPlaces.hasNext(); ) {
            RBLSitzplatz platz = itPlaces.next();
            if (rule.check(platz)) {
                if (lastPlace == null) {
                    lastPlace = platz;
                } else {
                    if (lastPlace.getSitzAsInt() == platz.getSitzAsInt() - 1) {
                        result.Check = true;
                        result.Info = "" + platz.toString() + " und " + lastPlace.toString();
                        result.sitzplatz = platz;
                        result.Name = game.getName() + " Nachbarn";
                        return result;
                    }
                    lastPlace = platz;
                }
            }
        }

        return result;
    }
}
