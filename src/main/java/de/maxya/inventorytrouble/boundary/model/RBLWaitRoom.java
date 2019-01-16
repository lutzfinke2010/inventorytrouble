package de.maxya.inventorytrouble.boundary.model;

import de.maxya.inventorytrouble.control.schedule.RblGameSearchOption;

import java.util.ArrayList;
import java.util.List;

public class RBLWaitRoom {
    private int counter;

    public RBLWaitRoom(){
        counter = -1;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
