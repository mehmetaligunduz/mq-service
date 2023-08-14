package com.mqservice.mq;

import com.mqservice.configuration.MqConfiguration;
import com.mqservice.entity.MessageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MqServiceImpl implements MqService {

    private final RabbitTemplate template;

    @Override
    public void publish(String message, String to) {
        template.convertAndSend(
                MqConfiguration.OTP_EXCHANGE,
                MqConfiguration.OTP_ROUTING_KEY,
                new MessageEntity(message, to));
    }

}
