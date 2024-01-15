package com.b5wang.architect.rabbitmqproducer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue textMessageQueue(){
        return new Queue("textMessage");
    }

}
