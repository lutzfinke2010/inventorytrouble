package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RBLRulesManager {

    public RBLRulesManager() {

    }

    public List<RBLRuleResult> check(RBLGames game, RblGameSearchOption searchOption) {
        List<RBLRuleResult> resultList = new ArrayList<>();
        for (Iterator<RBLRule> itRules = searchOption.getRules().iterator(); itRules.hasNext(); ) {
            RBLRule rule = itRules.next();
            if (!rule.shouldSearchNeighbours()) {
                for (Iterator<RBLSitzplatz> itPlaces = game.getPlaetze().iterator(); itPlaces.hasNext(); ) {
                    RBLSitzplatz platz = itPlaces.next();
                    if (!rule.shouldSearchNeighbours()) {
                        if (rule.check(platz)) {
                            RBLRuleResult result = new RBLRuleResult();
                            result.Check = true;
                            result.Info = rule.getName();
                            result.link = game.getLink();
                            result.Name = game.getName();
                            result.sitzplatz = platz;
                            resultList.add(result);
                        }
                    }
                }
            } else {
                resultList.add(new NeighbourChecker().check(game, searchOption, rule));
            }
        }
        return resultList;
    }

    public RBLRuleResult checkNeighbours(RBLGames game, RblGameSearchOption searchOption) {
        RBLRuleResult result = new RBLRuleResult();

        for (Iterator<RBLRule> itRules = searchOption.getRules().iterator(); itRules.hasNext(); ) {
            RBLRule rule = itRules.next();
            result = new NeighbourChecker().check(game, searchOption, rule);
            if (result.Check) {
                return result;
            }
        }
        return result;
    }
}
