package de.maxya.inventorytrouble.control;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatzAnzahlVerlauf;

import java.util.List;

public interface RBLGameService {

    RBLGames createRBLGame(String tenantId, RBLGames rblGames);

    List<RBLGames> getRBLGames(String tenantId);
    List<RBLGames> getRBLGamesMitBBlockPlaetzen(String tenantId);

    List<RBLSitzplatz> getSitzplaetze(String tenantId);

    List<RBLSitzplatzAnzahlVerlauf> getRBLGamesVerlauf(String tenantId);

    long count();
    long countByName(String name);
    long countSitzplatze();
}
