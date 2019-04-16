package de.maxya.inventorytrouble.control.login;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Service
public class UserDataService {

    private final ArrayList<UserData> userList;
    private Random r = new Random(new Date().getTime());

    public UserDataService(){
        this.userList = new ArrayList<UserData>();
        this.userList.add(
                new UserData()
                        .setName("ebaykleinanzeigenmaxmueller@gmail.com")
                        .setPasswort("maxmueller123"));
        this.userList.add(
                new UserData()
                        .setName("kaibrunner456@gmail.com")
                        .setPasswort("kaibrunner123"));
        this.userList.add(
                new UserData()
                        .setName("stefanmeyerpegau@gmail.com")
                        .setPasswort("stefanmeyer123"));
    }

    public UserData getUserData() {
        int index = r.nextInt(this.userList.size());
        if (index >= 0 && index < userList.size()){
            return userList.get(index);
        }
        return userList.get(0);
    }

}
