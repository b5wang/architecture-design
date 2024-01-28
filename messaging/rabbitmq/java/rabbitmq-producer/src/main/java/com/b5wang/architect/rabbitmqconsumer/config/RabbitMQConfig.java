package com.b5wang.architect.rabbitmqconsumer.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String EXCHANGE_NAME_NOTIFICATION = "exchange.fanout.notification";

    public static final String EXCHANGE_NAME_REGION_NOTIFICATION = "exchange.direct.region.notification";

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
    public FanoutExchange notificationFanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME_NOTIFICATION);
    }

    @Bean
    public DirectExchange regionNotificationDirectExchange(){
        return new DirectExchange(EXCHANGE_NAME_REGION_NOTIFICATION);
    }
}
