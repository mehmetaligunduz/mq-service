package com.mqservice.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfiguration {

    public static final String OTP_QUEUE = "otp_code_sms_queue";
    public static final String OTP_EXCHANGE = "otp_code_sms_exchange";
    public static final String OTP_ROUTING_KEY = "otp_code_sms_routing_key";


    @Bean
    public Queue queue() {
        return new Queue(OTP_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(OTP_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(OTP_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
