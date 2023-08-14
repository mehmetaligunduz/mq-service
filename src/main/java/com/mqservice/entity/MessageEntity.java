package com.mqservice.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class MessageEntity {

    private String id;

    private String message;

    private Date date;

    public MessageEntity(String message) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.date = new Date();

    }
}
