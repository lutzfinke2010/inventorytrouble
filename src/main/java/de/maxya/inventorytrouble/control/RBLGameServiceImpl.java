package de.maxya.inventorytrouble.control;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatzAnzahl;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatzAnzahlVerlauf;
import de.maxya.inventorytrouble.control.mapper.RBLGameMapper;
import de.maxya.inventorytrouble.control.mapper.RBLSitzplatzMapper;
import de.maxya.inventorytrouble.entity.RBLGameEntity;
import de.maxya.inventorytrouble.entity.RBLSitzplatzEntity;
import de.maxya.inventorytrouble.entity.repository.RBLGameRepository;
import de.maxya.inventorytrouble.entity.repository.RBLSitzplatzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RBLGameServiceImpl implements RBLGameService {

    @Autowired
    RBLGameRepository rblGameRepository;

    @Autowired
    RBLSitzplatzRepository rblSitzplatzRepository;

    @Transactional
    @Override
    public RBLGames createRBLGame(String tenantId, RBLGames rblGames) {
        final RBLGameEntity rblGameEnt = RBLGameMapper.mapToRBLGameEntity(rblGames, tenantId);
        Set bookAs = new HashSet<RBLSitzplatzEntity>();
        for (Iterator<RBLSitzplatz> it = rblGames.getPlaetze().iterator(); it.hasNext(); ) {
            RBLSitzplatz sitzplatz = it.next();
            RBLSitzplatzEntity entity = RBLSitzplatzMapper.mapToRBLSitzplatzEntity(sitzplatz, tenantId);
            entity.setGame(rblGameEnt);
            bookAs.add(entity);
        }
        rblGameEnt.setPlaetze(bookAs);
        final RBLGameEntity rblGameEntSaved = this.rblGameRepository.save(rblGameEnt);
        return RBLGameMapper.mapFromRBLGameEntity(rblGameEntSaved);
    }

    @Transactional
    @Override
    public List<RBLGames> getRBLGames(String tenantId) {
        List<RBLGames> list = new ArrayList<RBLGames>();
        Date now = new Date();
        Iterator<RBLGameEntity> iter = this.rblGameRepository.findByStartDateAfter(now).iterator();
        while (iter.hasNext()) {
            list.add(RBLGameMapper.mapFromRBLGameEntity(iter.next()));
        }
        return list;
    }

    @Override
    public List<RBLGames> getRBLGamesMitBBlockPlaetzen(String tenantId) {
        List<RBLGames> list = new ArrayList<RBLGames>();
        Iterator<RBLGameEntity> iter = this.rblGameRepository.findByPlaetzeBereichBetween("25", "31").iterator();
        while (iter.hasNext()) {
            list.add(RBLGameMapper.mapFromRBLGameEntity(iter.next()));
        }
        return list;
    }

    @Override
    public List<RBLSitzplatz> getSitzplaetze(String tenantId) {
        List<RBLSitzplatz> list = new ArrayList<RBLSitzplatz>();
        Iterator<RBLSitzplatzEntity> iter = this.rblSitzplatzRepository.findAll().iterator();
        while (iter.hasNext()) {
            list.add(RBLSitzplatzMapper.mapFromRBLSítzplatzEntity(iter.next()));
        }
        return list;
    }

    @Override
    public List<RBLSitzplatzAnzahlVerlauf> getRBLGamesVerlauf(String tenantId) {
        List<RBLSitzplatzAnzahlVerlauf> erg = new ArrayList<>();

        List<RBLGames> rblGames = getRBLGames(tenantId);
        Iterator<RBLGames> it = rblGames.iterator();
        while (it.hasNext()) {
            RBLGames entity = it.next();
            if (erg.size() == 0) {
                addNewVerlaufToList(erg, entity);
            } else {
                addVerlaufToExistingGame(erg, entity);
            }
        }

        //wenn mehr als 2000 dann nur jeden 3ten
        Iterator<RBLSitzplatzAnzahlVerlauf> itErg = erg.iterator();
        while (itErg.hasNext()) {
            RBLSitzplatzAnzahlVerlauf entity = itErg.next();
            if (entity.getPlaetze().size() > 2000) {
                List<RBLSitzplatzAnzahl> reduziertePlaetze = new ArrayList<>();
                Iterator<RBLSitzplatzAnzahl> itPlaetze = entity.getPlaetze().iterator();
                int index = 0;
                while (itPlaetze.hasNext()) {
                    RBLSitzplatzAnzahl platz = itPlaetze.next();
                    index ++;
                    if ( index % 20 == 0 || platz.getCountBBlock() > 0){
                        reduziertePlaetze.add(platz);
                    }
                }
                entity.setPlaetze(reduziertePlaetze);
            }
        }

        return erg;
    }

    @Override
    public long count() {
        return rblGameRepository.count();
    }

    @Override
    public long countByName(String name) {
        return rblGameRepository.countByName(name);
    }

    @Override
    public long countSitzplatze() {
        return rblSitzplatzRepository.count();
    }

    private void addNewVerlaufToList(List<RBLSitzplatzAnzahlVerlauf> erg, RBLGames entity) {
        RBLSitzplatzAnzahlVerlauf verlauf = new RBLSitzplatzAnzahlVerlauf();
        verlauf.setName(entity.getName());
        if (entity.getStartDate() != null) {
            verlauf.setStartDate(entity.getStartDate());
        }
        RBLSitzplatzAnzahl anzahl = new RBLSitzplatzAnzahl();
        anzahl.setZeitpunkt(entity.getCreateDate());
        anzahl.setCount(entity.getCountSitzplaetze());
        anzahl.setCountBBlock(entity.getCountBBLock());
        verlauf.getPlaetze().add(anzahl);
        erg.add(verlauf);
    }

    private void addVerlaufToExistingGame(List<RBLSitzplatzAnzahlVerlauf> erg, RBLGames entity) {
        Iterator<RBLSitzplatzAnzahlVerlauf> it = erg.iterator();
        boolean found = false;
        while (it.hasNext()) {
            RBLSitzplatzAnzahlVerlauf curr = it.next();
            if (gameExists(entity, curr)) {
                if (curr.getStartDate() == null && entity.getStartDate() != null) {
                    curr.setStartDate(entity.getStartDate());
                }
                RBLSitzplatzAnzahl anzahl = new RBLSitzplatzAnzahl();
                anzahl.setZeitpunkt(entity.getCreateDate());
                anzahl.setCount(entity.getCountSitzplaetze());
                anzahl.setCountBBlock(entity.getCountBBLock());
                curr.getPlaetze().add(anzahl);
                found = true;
                break;
            }
        }
        if (!found) {
            addNewVerlaufToList(erg, entity);
        }
        return;
    }

    private boolean gameExists(RBLGames entity, RBLSitzplatzAnzahlVerlauf curr) {
        boolean sameName = curr.getName().equals(entity.getName());
        boolean sameDate = false;
        if (curr.getStartDate() == null) {
            sameDate = true;
        } else {
            sameDate = curr.getStartDate().equals(entity.getStartDate());
        }
        return sameName && sameDate;
    }
}