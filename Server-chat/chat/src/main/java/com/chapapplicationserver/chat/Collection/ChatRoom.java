package com.chapapplicationserver.chat.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("ChatRoom")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatRoom {
    @Id
    private int chatRoomId;
    private String chatRoomName;
    private ArrayList<User> chatRoomUsers;
    private ArrayList<ChatMessage> chatRoomChatMessages;

    public ChatRoom(int chatRoomId, String chatRoomName, ArrayList<User> chatRoomUsers, ArrayList<ChatMessage> chatRoomChatMessages) {
        this.chatRoomId = chatRoomId;
        this.chatRoomName = chatRoomName;
        this.chatRoomUsers = chatRoomUsers;
        this.chatRoomChatMessages = chatRoomChatMessages;
    }



    public int getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(int chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public ArrayList<User> getChatRoomUsers() {
        return chatRoomUsers;
    }

    public void setChatRoomUsers(ArrayList<User> chatRoomUsers) {
        this.chatRoomUsers = chatRoomUsers;
    }

    public ArrayList<ChatMessage> getChatRoomMessages() {
        return chatRoomChatMessages;
    }

    public void setChatRoomMessages(ArrayList<ChatMessage> chatRoomChatMessages) {
        this.chatRoomChatMessages = chatRoomChatMessages;
    }




}

