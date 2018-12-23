package de.maxya.inventorytrouble.entity;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = TableConstantsRBLGame.SQL_TABLE_NAME)
@SequenceGenerator(name = TableConstantsRBLGame.SQL_SEQUENCE_NAME_ARTIKEL_ID_SEQ, sequenceName = TableConstantsRBLGame.SQL_SEQUENCE_NAME_ARTIKEL_ID_SEQ, allocationSize = 1)
public class RBLGameEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TableConstantsRBLGame.SQL_SEQUENCE_NAME_ARTIKEL_ID_SEQ)
    @Column(name = TableConstantsArtkelItem.SQL_COLUMN_NAME_ID_PK)
    private long id;

    @Column(name = TableConstantsRBLGame.SQL_COLUMN_NAME_LINK)
    private String link;

    @Version
    @Column(name = TableConstantsRBLGame.SQL_COLUMN_NAME_VERSION_NUMBR, nullable = false)
    private int versionNumber;

    @Column(name = TableConstantsRBLGame.SQL_COLUMN_NAME_NAME)
    private String name;

    @Column(name=TableConstantsRBLGame.SQL_COLUMN_NAME_TENANT_ID)
    private String tenantId;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RBLSitzplatzEntity> plaetze;

    @Column(name=TableConstantsRBLGame.SQL_COLUMN_NAME_STARTDATE, nullable = true)
    private Date startDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Set<RBLSitzplatzEntity> getPlaetze() {
        if (plaetze == null){
            plaetze = new HashSet<RBLSitzplatzEntity>();
        }
        return plaetze;
    }

    public void setPlaetze(Set<RBLSitzplatzEntity> plaetze) {
        this.plaetze = plaetze;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }
}
