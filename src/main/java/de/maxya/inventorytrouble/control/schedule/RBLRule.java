package de.maxya.inventorytrouble.control.schedule;


import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;

public interface RBLRule {

    int getId();

    String getName();

    boolean check(RBLSitzplatz rblPlatz);

    boolean shouldSearchNeighbours();
}
