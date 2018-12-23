package de.maxya.inventorytrouble.control;

import de.maxya.inventorytrouble.boundary.model.Artikel;
import de.maxya.inventorytrouble.control.mapper.ArtikelMapper;
import de.maxya.inventorytrouble.control.rblparser.RBLPageParser;
import de.maxya.inventorytrouble.entity.ArtikelEntity;
import de.maxya.inventorytrouble.entity.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ArtikelServiceImpl implements ArtikelService {

    @Autowired
    ArtikelRepository artikelRepository;

    @Transactional
    @Override
    public Artikel createArtikel(String tenantId, Artikel artikel) {
        final ArtikelEntity artEnt = ArtikelMapper.mapToArtikelEntity(artikel, tenantId);
        final ArtikelEntity artEntSaved = this.artikelRepository.save(artEnt);
        return ArtikelMapper.mapFromArtikelEntity(artEntSaved);
    }

    @Transactional
    @Override
    public List<Artikel> getArtikels(String tenantId) {
        List<Artikel> list = new ArrayList<Artikel>();
        Iterator<ArtikelEntity> iter = artikelRepository.findAll().iterator();
        while (iter.hasNext()) {
            list.add(ArtikelMapper.mapFromArtikelEntity(iter.next()));
        }
        return list;
    }
}
