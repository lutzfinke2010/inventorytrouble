package de.maxya.inventorytrouble.boundary.model;

import de.maxya.inventorytrouble.control.rules.RBLRuleResult;

public class RBLRuleResultResponse {
    RBLRuleResult content;

    public RBLRuleResultResponse() {
    }

    public RBLRuleResult getContent() {
        return content;
    }

    public RBLRuleResultResponse(RBLRuleResult content) {
        this.content = content;
    }
}
