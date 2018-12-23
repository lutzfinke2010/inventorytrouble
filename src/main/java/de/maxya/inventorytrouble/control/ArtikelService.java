package de.maxya.inventorytrouble.control;

import de.maxya.inventorytrouble.boundary.model.Artikel;

import java.util.List;

public interface ArtikelService {

    Artikel createArtikel(String tenantId, Artikel artikel);

    List<Artikel> getArtikels(String tenantId);
}
