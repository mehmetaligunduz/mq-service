package com.mqservice.mq;

import com.mqservice.entity.MessageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MqServiceImpl implements MqService {

    private final RabbitTemplate template;

    @Value("${rabbitmq-otp.exchange}")
    private String exchange;

    @Value("${rabbitmq-otp.routingKey}")
    private String routingKey;

    @Override
    public void publish(String message, String to) {

        template.convertAndSend(
                exchange,
                routingKey,
                new MessageEntity(message, to));

    }

}
