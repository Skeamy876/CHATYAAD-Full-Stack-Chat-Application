package com.chapapplicationserver.chat.Services;

import com.chapapplicationserver.chat.Collection.ChatMessage;
import com.chapapplicationserver.chat.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    @Autowired
    private MessageRepository messageRepository;

    public ChatMessage Save(ChatMessage chatMessage){
        return messageRepository.save(chatMessage);
    }





}
