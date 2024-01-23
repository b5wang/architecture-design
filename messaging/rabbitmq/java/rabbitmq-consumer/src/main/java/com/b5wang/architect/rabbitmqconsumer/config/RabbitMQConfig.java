package com.b5wang.architect.rabbitmqconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String EXCHANGE_NAME_NOTIFICATION = "exchange.fanout.notification";

    /**
     * Config a queue
     * */
    @Bean
    public Queue textMessageQueue(){
        return new Queue(QUEUE_NAME_TEXT_MESSAGE);
    }

    /**
     * An anonymous queue binds to notification notification
     * */
    @Bean
    public Queue notificationAnonymousQueue() {
        return new AnonymousQueue();
    }

    /**
     * Define a fan-out exchange.
     * */
    @Bean
    public FanoutExchange notificationFanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME_NOTIFICATION);
    }

    @Bean
    public Binding bindingNotificationFanoutExchange(FanoutExchange notificationFanoutExchange, Queue notificationAnonymousQueue) {
        return BindingBuilder.bind(notificationAnonymousQueue).to(notificationFanoutExchange);
    }
}
