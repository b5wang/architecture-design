package com.b5wang.architect.rabbitmqconsumer.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String EXCHANGE_NAME_SYSTEM_NOTIFICATION = "exchange.fanout.systemNotification";

    /**
     * Config a queue
     * */
    @Bean
    public Queue textMessageQueue(){
        return new Queue(QUEUE_NAME_TEXT_MESSAGE);
    }

    /**
     * Define a fan-out exchange.
     * */
    @Bean
    public FanoutExchange systemNotification(){
        return new FanoutExchange(EXCHANGE_NAME_SYSTEM_NOTIFICATION);
    }
}
