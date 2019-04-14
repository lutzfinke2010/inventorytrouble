package de.maxya.inventorytrouble;


import de.maxya.inventorytrouble.control.login.UserData;
import de.maxya.inventorytrouble.control.login.UserDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataServiceTests {

    @Test
    public void getUserData_call10Times_checkOutput() throws IOException {
        //arrange
        UserDataService service = new UserDataService();

        //act
        for (int i = 0; i < 100; i++){
            UserData data = service.getUserData();
            System.out.println(data.toString());
        }

        //assert
    }
}
