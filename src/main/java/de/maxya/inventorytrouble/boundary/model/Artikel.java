package de.maxya.inventorytrouble.boundary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Artikel {

    private Long id;
    private String name;
    private String tenantId;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }
    @JsonSetter
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("tenant_id")
    public String getTenantId() {
        return tenantId;
    }
    @JsonSetter
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
