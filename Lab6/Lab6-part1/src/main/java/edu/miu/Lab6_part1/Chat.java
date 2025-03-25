package edu.miu.Lab6_part1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Chat { // Model object

    @Id
    private Integer charID;
    private String chatMessage;

    public Chat(){

    }

    public Chat(Integer charID, String chatMessage) {
        this.charID = charID;
        this.chatMessage = chatMessage;
    }

    public Integer getCharID() {
        return charID;
    }

    public void setCharID(Integer charID) {
        this.charID = charID;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }
}
