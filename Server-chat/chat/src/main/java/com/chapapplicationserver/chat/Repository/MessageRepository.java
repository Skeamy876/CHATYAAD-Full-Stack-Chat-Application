package com.chapapplicationserver.chat.Repository;

import com.chapapplicationserver.chat.Collection.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends MongoRepository<ChatMessage,String> {
}
