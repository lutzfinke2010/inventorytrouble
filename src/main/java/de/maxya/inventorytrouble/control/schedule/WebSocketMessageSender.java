package de.maxya.inventorytrouble.control.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.maxya.inventorytrouble.boundary.model.*;
import de.maxya.inventorytrouble.control.rules.RBLRuleResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static de.maxya.inventorytrouble.control.schedule.RblParserSchedule.distinctByKey;

public class WebSocketMessageSender {

    private final SimpMessagingTemplate templateWebSocket;
    private final KafkaTemplate<Object, Object> template;
    private List<RblGameSearchOption> searchOptions;
    private List<RBLGames> games;
    private int waitRoomCounter;

    public WebSocketMessageSender(SimpMessagingTemplate templateWebSocket, KafkaTemplate<Object, Object> template) {
        this.templateWebSocket = templateWebSocket;
        this.template = template;
        this.reset();
    }

    public WebSocketMessageSender reset(){
        this.games = new ArrayList<>();
        this.waitRoomCounter = -1;
        this.searchOptions = new ArrayList<>();
        return this;
    }

    public List<RBLRuleResult> elementsToSend = new ArrayList<>();

    public WebSocketMessageSender setFindings(List<RBLRuleResult> findings) {
        elementsToSend = findings;
        return this;
    }

    public WebSocketMessageSender distinct() {
        elementsToSend = elementsToSend.stream()
                .filter(distinctByKey(p -> p.Name))
                .collect(Collectors.toList());
        return this;
    }

    public void send() {
        if (elementsToSend != null && elementsToSend.size() > 0) {
            sendRblRuleResults();
        }
        if (this.searchOptions != null && searchOptions.size() > 0) {
            sendSearchOptions();
        }
        if (this.waitRoomCounter >= 0) {
            sendWaitRoomCounter();
        }
    }

    private void sendSearchOptions() {
        RBLSearchOptionContainer container = new RBLSearchOptionContainer();
        container.setSearchOptions(searchOptions);
        container.setScanedGames(games);
        container.setDate(new Date());
        sendWebSocketMessage(container);
    }

    private void sendRblRuleResults() {
        elementsToSend.stream().forEach(result -> {
            sendWebSocketMessage(result);
        });
    }

    private void sendWaitRoomCounter() {
        RBLWaitRoom waitRoom = new RBLWaitRoom();
        waitRoom.setCounter(waitRoomCounter);
        this.sendWebSocketMessage(waitRoom);
    }

    private void sendWebSocketMessage(RBLRuleResult game) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String gameAsJsonString = mapper.writeValueAsString(game);
            this.template.send("topic1", gameAsJsonString);
            this.templateWebSocket.convertAndSend("/topic/user", new RBLRuleResultResponse(game));
        } catch (JsonProcessingException e) {
        } catch (
                Exception e) {
            //e.printStackTrace();
        }
    }

    private void sendWebSocketMessage(RBLSearchOptionContainer container) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String gameAsJsonString = mapper.writeValueAsString(container);
            this.template.send("topic1", gameAsJsonString);
            this.templateWebSocket.convertAndSend("/topic/searchoptions", new RBLSearchOptionContainerResponse(container));
        } catch (JsonProcessingException e) {
        } catch (
                Exception e) {
            //e.printStackTrace();
        }
    }

    private void sendWebSocketMessage(RBLWaitRoom waitRoom) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String gameAsJsonString = mapper.writeValueAsString(waitRoom);
            this.template.send("topic1", gameAsJsonString);
            this.templateWebSocket.convertAndSend("/topic/waitroomcounter", new RBLWaitRoomResponse(waitRoom));
        } catch (JsonProcessingException e) {
        } catch (
                Exception e) {
            //e.printStackTrace();
        }
    }

    public WebSocketMessageSender setSearchOptions(List<RblGameSearchOption> searchOptionsForGames) {
        this.searchOptions = searchOptionsForGames;
        return this;
    }

    public WebSocketMessageSender setRBLGames(List<RBLGames> games) {
        this.games = games;
        return this;
    }

    public WebSocketMessageSender setWaitRoomCounter(int count) {
        this.waitRoomCounter = count;
        return this;
    }
}
