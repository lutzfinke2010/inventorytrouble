package de.maxya.inventorytrouble.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = TableConstantsRBLSitzplatz.SQL_TABLE_NAME)
@SequenceGenerator(name = TableConstantsRBLSitzplatz.SQL_SEQUENCE_NAME_RBLSITZPLATZ_ID_SEQ, sequenceName = TableConstantsRBLSitzplatz.SQL_SEQUENCE_NAME_RBLSITZPLATZ_ID_SEQ, allocationSize = 1)
public class RBLSitzplatzEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TableConstantsRBLSitzplatz.SQL_SEQUENCE_NAME_RBLSITZPLATZ_ID_SEQ)
    @Column(name = TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_ID_PK)
    private long id;

    @Column(name=TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_TENANT_ID)
    private String tenantId;

    @Column(name = TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_BEREICH)
    private String bereich;

    @Column(name = TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_REIHE)
    private String reihe;

    @Column(name = TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_SITZ)
    private String sitz;

    @Column(name = TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_KATEGORIE)
    private String kategorie;

    @Version
    @Column(name = TableConstantsRBLSitzplatz.SQL_COLUMN_NAME_VERSION_NUMBR, nullable = false)
    private int versionNumber;

    @ManyToOne
    private RBLGameEntity game;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBereich() {
        return bereich;
    }

    public void setBereich(String bereich) {
        this.bereich = bereich;
    }

    public String getReihe() {
        return reihe;
    }

    public void setReihe(String reihe) {
        this.reihe = reihe;
    }

    public String getSitz() {
        return sitz;
    }

    public void setSitz(String sitz) {
        this.sitz = sitz;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public RBLGameEntity getGame() {
        return game;
    }

    public void setGame(RBLGameEntity game) {
        this.game = game;
    }
}
