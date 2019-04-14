package de.maxya.inventorytrouble.control.login;

import org.springframework.stereotype.Service;

public class UserData {
    private String name;
    private String passwort;

    public UserData setName(String name) {
        this.name = name;
        return this;
    }

    public UserData setPasswort(String passwort) {
        this.passwort = passwort;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getPasswort() {
        return this.passwort;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Passwort:" + this.getPasswort();
    }
}
