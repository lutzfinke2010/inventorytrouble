package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;

import java.util.Comparator;

public class RBLSitzplatzComparer implements Comparator<RBLSitzplatz> {
        @Override
        public int compare(RBLSitzplatz o1, RBLSitzplatz o2) {
            if (o1.getSortNumber() == o2.getSortNumber()){
                return 0;
            }
            return o1.getSortNumber() - o2.getSortNumber();
        }
}
