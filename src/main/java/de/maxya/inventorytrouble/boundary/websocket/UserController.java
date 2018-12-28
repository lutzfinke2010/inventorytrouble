package de.maxya.inventorytrouble.boundary.websocket;

import de.maxya.inventorytrouble.boundary.model.User;
import de.maxya.inventorytrouble.boundary.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) {

        return new UserResponse("Hi " + user.getName());
    }
}

