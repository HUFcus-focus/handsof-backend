package com.handsof.backend.document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("messages")
@Getter
@NoArgsConstructor
public class Message {
    @Id
    private String id;

    private String message;

    private String application;

    private String member;

    @Builder
    public Message(String message, String application, String member) {
        this.message = message;
        this.application = application;
        this.member = member;
    }
}
