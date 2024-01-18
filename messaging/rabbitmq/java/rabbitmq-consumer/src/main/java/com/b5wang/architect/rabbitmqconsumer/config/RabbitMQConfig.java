package com.b5wang.architect.rabbitmqconsumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    /**
     * Config a queue
     * */
    @Bean
    public Queue textMessageQueue(){
        return new Queue(QUEUE_NAME_TEXT_MESSAGE);
    }

}
