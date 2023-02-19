package com.chapapplicationserver.chat.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("Messages")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChatMessage {
    @Id
    private String content;
    private String sender;
    private String receiverName;
    private String timestamp;
    private Status type;

    public enum Status {
        CHAT,
        JOIN,
        LEAVE
    }


}
