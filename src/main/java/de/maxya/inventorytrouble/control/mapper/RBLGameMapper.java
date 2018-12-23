package de.maxya.inventorytrouble.control.mapper;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.entity.RBLGameEntity;
import de.maxya.inventorytrouble.entity.RBLSitzplatzEntity;

import java.util.Iterator;

public class RBLGameMapper {
    public static RBLGameEntity mapToRBLGameEntity(RBLGames rblGame, String tenantId) {
        if (null == rblGame) {
            return null;
        }
        RBLGameEntity gameEnt = new RBLGameEntity();
        gameEnt.setVersionNumber(1);
        gameEnt.setName(rblGame.getName());
        gameEnt.setLink(rblGame.getLink());
        gameEnt.setCreateDate(rblGame.getCreateDate());
        gameEnt.setModifyDate(rblGame.getModifyDate());
        gameEnt.setTenantId(tenantId);
        gameEnt.setStartDate(rblGame.getStartDate());

        for (Iterator<RBLSitzplatz> it = rblGame.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz sitzplatz = it.next();
            gameEnt.getPlaetze().add( RBLSitzplatzMapper.mapToRBLSitzplatzEntity(sitzplatz, tenantId));
        }

        return gameEnt;
    }

    public static RBLGames mapFromRBLGameEntity(RBLGameEntity rblGameEnt) {
        if (null == rblGameEnt) {
            return null;
        }
        RBLGames rblGames = new RBLGames();
        rblGames.setName(rblGameEnt.getName());
        rblGames.setLink(rblGameEnt.getLink());
        rblGames.setId(rblGameEnt.getId());
        rblGames.setCreateDate(rblGameEnt.getCreateDate());
        if (rblGameEnt.getStartDate() != null){
            rblGames.setStartDate(rblGameEnt.getStartDate());
        }
        rblGames.setModifyDate(rblGameEnt.getModifyDate());
        rblGames.setCountSitzplaetze(rblGameEnt.getPlaetze().size());

        for (Iterator<RBLSitzplatzEntity> it = rblGameEnt.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatzEntity sitzplatz = it.next();
            rblGames.getPlaetze().add( RBLSitzplatzMapper.mapFromRBLSítzplatzEntity(sitzplatz));
        }

        return rblGames;
    }
}
