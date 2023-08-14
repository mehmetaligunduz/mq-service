package com.mqservice.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class MessageEntity {

    private String id;

    private String message;

    private String to;

    private Date date;

    public MessageEntity(String message, String to) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.to = "+90" + to;
        this.date = new Date();

    }
}
