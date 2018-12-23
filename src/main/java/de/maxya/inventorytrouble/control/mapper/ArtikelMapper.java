package de.maxya.inventorytrouble.control.mapper;

import de.maxya.inventorytrouble.boundary.model.Artikel;
import de.maxya.inventorytrouble.entity.ArtikelEntity;

public class ArtikelMapper {
    public static ArtikelEntity mapToArtikelEntity(Artikel artikel, String tenantId){
        if (null == artikel){
            return null;
        }
        ArtikelEntity artEnt = new ArtikelEntity();
        artEnt.setVersionNumber(1);
        artEnt.setName(artikel.getName());
        artEnt.setTenantId(artikel.getTenantId());
        return artEnt;
    }

    public static Artikel mapFromArtikelEntity(ArtikelEntity artEntSaved) {
        if (null == artEntSaved){
            return null;
        }
        Artikel artikel = new Artikel();
        artikel.setName(""+artEntSaved.getVersionNumber());
        return artikel;
    }
}
