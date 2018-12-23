package de.maxya.inventorytrouble.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = TableConstantsArtkelItem.SQL_TABLE_NAME)
@SequenceGenerator(name=TableConstantsArtkelItem.SQL_SEQUENCE_NAME_ARTIKEL_ID_SEQ, sequenceName = TableConstantsArtkelItem.SQL_SEQUENCE_NAME_ARTIKEL_ID_SEQ, allocationSize = 1)
public class ArtikelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TableConstantsArtkelItem.SQL_SEQUENCE_NAME_ARTIKEL_ID_SEQ)
    @Column(name=TableConstantsArtkelItem.SQL_COLUMN_NAME_ID_PK)
    private long id;

    @Version
    @Column(name=TableConstantsArtkelItem.SQL_COLUMN_NAME_VERSION_NUMBR, nullable = false)
    private int versionNumber;

    @Column(name=TableConstantsArtkelItem.SQL_COLUMN_NAME_NAME)
    private String name;

    @Column(name=TableConstantsArtkelItem.SQL_COLUMN_NAME_TENANT_ID)
    private String tenantId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
