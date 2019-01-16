package de.maxya.inventorytrouble.boundary.websocket;

import de.maxya.inventorytrouble.boundary.model.RBLRuleResultResponse;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class RblGamesController {


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public RBLRuleResultResponse getRBLGames(RBLRuleResult games) {
        return new RBLRuleResultResponse(games);
    }
}

