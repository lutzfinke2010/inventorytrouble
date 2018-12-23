package de.maxya.inventorytrouble.boundary.websocket;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/games")
    public RBLGames games(String name) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new RBLGames(name);
    }

}
