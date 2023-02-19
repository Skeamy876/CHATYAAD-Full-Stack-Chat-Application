package com.chapapplicationserver.chat.Services;

import com.chapapplicationserver.chat.Collection.ChatMessage;
import com.chapapplicationserver.chat.Collection.ChatRoom;
import com.chapapplicationserver.chat.Collection.User;
import com.chapapplicationserver.chat.Repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChatRoomService {

    private ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoom> getAllChatRooms(){
        return chatRoomRepository.findAll();
    }

    public ChatRoom getChatRoomById(Integer id){
        return chatRoomRepository.findById(id).get();
    }

    public ChatRoom getChatRoomByName(String chatRoomName){

        return chatRoomRepository.findBychatRoomName(chatRoomName).get();
    }

    public ResponseEntity<ChatRoom> saveChatRoom(ChatRoom chatRoom) {
        chatRoom.setChatRoomId(chatRoomRepository.findAll().size() + 1);
        //chatRoom.getChatRoomName();
        return new ResponseEntity<>(chatRoomRepository.save(chatRoom), HttpStatus.CREATED);
    }

    public void broadcastMessage(){
    }
    public void addUser(){
    }
    public void removeUser(){
    }
}

