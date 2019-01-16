package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RblGameChecker {

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);
    private List<GameWithBBlock> gamesWithBorDBlock;
    private List<RBLGames> gamesToSave;
    private RBLRulesManager rulesManager;

    public RblGameChecker() {
        this.rulesManager = new RBLRulesManager();
        this.searchOptionsForGames = new ArrayList<>();
    }

    public void logSearchOptions() {
        LOGGER.info("-----------------------------");
        LOGGER.info("-----SEARCH-OPTIONS----------");
        LOGGER.info("-----------------------------");
        for (Iterator<RblGameSearchOption> it = this.searchOptionsForGames.iterator(); it.hasNext(); ) {
            RblGameSearchOption gameToSearch = it.next();
            gameToSearch.log();
        }
        LOGGER.info("-----------------------------");
    }

    public List<RblGameSearchOption> getSearchOptionsForGames(){
        return this.searchOptionsForGames;
    }

    public int getCountOfGamesWithBBlockTickets() {
        if (gamesWithBorDBlock == null) {
            return 0;
        }
        return gamesWithBorDBlock.size();
    }

    public String getBodyText() {
        String bodyText = "";
        for (Iterator<GameWithBBlock> it = gamesWithBorDBlock.iterator(); it.hasNext(); ) {
            GameWithBBlock game = it.next();
            bodyText += game.BlockPlaetze + " ";
        }
        return bodyText;
    }

    public String getHeaderText() {
        String headerText = "";
        for (Iterator<GameWithBBlock> it = gamesWithBorDBlock.iterator(); it.hasNext(); ) {
            GameWithBBlock game = it.next();
            headerText += game.Begegnung + " ";
        }
        return headerText;
    }

    public List<RBLGames> getGamesToSave() {
        return gamesToSave;
    }

    private List<RblGameSearchOption> searchOptionsForGames;

    public List<RBLRuleResult> checkRBLGameList(List<RBLGames> erg) {
        this.reset();
        List<RBLRuleResult> findings = new ArrayList<>();
        for (Iterator<RBLGames> it = erg.iterator(); it.hasNext(); ) {
            RBLGames game = it.next();
            gamesToSave.add(game);
            RblGameSearchOption searchOption = getSearchOptions(game);
            if (searchOption != null) {
                try {
                    List<RBLRuleResult> resultList = rulesManager.check(game, searchOption);
                    resultList.stream().forEach(result -> {
                        if (result.Check) {
                            LOGGER.warn("" + result.Info + "-BLOCK-Ticket found for " + game.getName() + "!!!!!!!!!! ");
                            findings.add(result);
                        }
                    });
                } catch (NumberFormatException ex) {
                }

                RBLRuleResult result = rulesManager.checkNeighbours(game, searchOption);
                if (result.Check) {
                    findings.add(result);
                    LOGGER.warn("Neighbours found " + result.Info + " for " + game.getName() + "!!!!!!!!!! ");
                }
            }
        }
        return findings;
    }

    private RblGameSearchOption getSearchOptions(RBLGames game) {
        for (Iterator<RblGameSearchOption> it = this.searchOptionsForGames.iterator(); it.hasNext(); ) {
            RblGameSearchOption gameToSearch = it.next();
            if (gameToSearch.name.equals(game.getName())) {
                return gameToSearch;
            }
        }
        return null;
    }

    public void reset() {
        this.gamesWithBorDBlock = new ArrayList<>();
        this.gamesToSave = new ArrayList<>();
    }

    public void addSearchOption(RblGameSearchOption gameName) {
        this.searchOptionsForGames.add(gameName);
    }

    public List<RblGameSearchOption> getSearchOptions() {
        return this.searchOptionsForGames;
    }

    public void changeSearchOptions(RblGameSearchOption searchOption) {
        boolean found = false;
        for (Iterator<RblGameSearchOption> it = this.searchOptionsForGames.iterator(); it.hasNext(); ) {
            RblGameSearchOption gameToSearch = it.next();
            if (gameToSearch.name.equals(searchOption.name)) {
                found = true;
                gameToSearch.setRules(searchOption.getRules());
            }
        }
        if (!found) {
            this.searchOptionsForGames.add(searchOption);
        }
    }
}
