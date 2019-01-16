package de.maxya.inventorytrouble.boundary.model;

import de.maxya.inventorytrouble.control.rules.RBLRuleResult;

public class RBLSearchOptionContainerResponse {
    RBLSearchOptionContainer content;

    public RBLSearchOptionContainerResponse() {
    }

    public RBLSearchOptionContainer getContent() {
        return content;
    }

    public RBLSearchOptionContainerResponse(RBLSearchOptionContainer content) {
        this.content = content;
    }
}
