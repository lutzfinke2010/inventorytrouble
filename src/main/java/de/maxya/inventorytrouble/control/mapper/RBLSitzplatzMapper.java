package de.maxya.inventorytrouble.control.mapper;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.entity.RBLGameEntity;
import de.maxya.inventorytrouble.entity.RBLSitzplatzEntity;

import java.util.Iterator;

public class RBLSitzplatzMapper {
    public static RBLSitzplatzEntity mapToRBLSitzplatzEntity(RBLSitzplatz rblSitzplatz, String tenantId) {
        if (null == rblSitzplatz) {
            return null;
        }
        RBLSitzplatzEntity gameEnt = new RBLSitzplatzEntity();
        gameEnt.setVersionNumber(1);
        gameEnt.setBereich(rblSitzplatz.getBereich());
        gameEnt.setKategorie(rblSitzplatz.getKategorie());
        gameEnt.setReihe(rblSitzplatz.getReihe());
        gameEnt.setSitz(rblSitzplatz.getSitz());
        gameEnt.setTenantId(tenantId);

        return gameEnt;
    }

    public static RBLSitzplatz mapFromRBLSítzplatzEntity(RBLSitzplatzEntity rblSitzplatzEnt) {
        if (null == rblSitzplatzEnt) {
            return null;
        }
        RBLSitzplatz rblSitzplatz = new RBLSitzplatz();
        rblSitzplatz.setKategorie(rblSitzplatzEnt.getKategorie());
        rblSitzplatz.setBereich(rblSitzplatzEnt.getBereich());
        rblSitzplatz.setReihe(rblSitzplatzEnt.getReihe());
        rblSitzplatz.setSitz(rblSitzplatzEnt.getSitz());
        rblSitzplatz.setId(rblSitzplatzEnt.getId());
        return rblSitzplatz;
    }
}
