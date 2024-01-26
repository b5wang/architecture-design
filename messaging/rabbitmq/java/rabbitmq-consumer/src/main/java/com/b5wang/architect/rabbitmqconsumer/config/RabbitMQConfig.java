package com.b5wang.architect.rabbitmqconsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String QUEUE_NAME_STRATEGY_NOTIFICATION = "queue.notification-";

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
        log.info("Init notificationAnonymousQueue");
        AnonymousQueue aq = new AnonymousQueue(new Base64UrlNamingStrategy(QUEUE_NAME_STRATEGY_NOTIFICATION));
        log.info("Init notificationAnonymousQueue - queue.name: {}", aq.getName());
        return aq;
    }

    /**
     * Define a fan-out exchange.
     * */
    @Bean
    public FanoutExchange notificationFanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME_NOTIFICATION);
    }

    @Bean
    public Binding notificationFanoutExchangeBinding(FanoutExchange notificationFanoutExchange,Queue notificationAnonymousQueue) {
        log.info("Exchange binding anonymous queue");
        return BindingBuilder.bind(notificationAnonymousQueue).to(notificationFanoutExchange);
    }
}
