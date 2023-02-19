package com.chapapplicationserver.chat.Repository;

import com.chapapplicationserver.chat.Collection.ChatRoom;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom,Integer> {
    Optional<ChatRoom> findBychatRoomName(String chatRoomName);
    List<ChatRoom> findAll();
    Optional<ChatRoom> findByChatRoomId(Integer integer);
}
