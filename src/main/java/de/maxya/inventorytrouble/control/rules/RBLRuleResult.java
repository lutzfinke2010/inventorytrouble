package de.maxya.inventorytrouble.control.rules;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;

public class RBLRuleResult {

    public String Name;

    public RBLRuleResult(){
        Check = false;
        Info = "";
        sitzplatz = new RBLSitzplatz();
        link = "";
        Name = "";
    }

    public boolean Check;

    public String Info;

    public RBLSitzplatz sitzplatz;

    public String link;
}
