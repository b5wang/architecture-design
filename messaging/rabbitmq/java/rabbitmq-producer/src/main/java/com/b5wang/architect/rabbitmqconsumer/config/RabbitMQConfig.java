package com.b5wang.architect.rabbitmqconsumer.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String QUEUE_NAME_APP_EVENT = "queue.appEvent.";

    public static final String EXCHANGE_NAME_NOTIFICATION = "exchange.fanout.notification";

    public static final String EXCHANGE_NAME_REGION_NOTIFICATION = "exchange.direct.region.notification";

    public static final String EXCHANGE_NAME_APP_EVENT = "exchange.topic.app.event";

    private static final Map QUEUE_ARGS = new HashMap<>();
    static{
        QUEUE_ARGS.put("x-queue-type", "quorum");
        QUEUE_ARGS.put("x-queue-leader-locator", "client-local");
    };

    @Value(value = "${spring.application.name}")
    private String appName;

    /**
     * Config a queue
     * */
    @Bean
    public Queue textMessageQueue(){
        return new Queue(QUEUE_NAME_TEXT_MESSAGE, true, false, false, QUEUE_ARGS);
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

    @Bean
    public TopicExchange appEventTopicExchange(){
        return new TopicExchange(EXCHANGE_NAME_APP_EVENT);
    }

    /**
     * Bind the queue to appEventTopicExchange
     * */
    @Bean
    public Queue appEventQueue(){
        return new Queue(QUEUE_NAME_APP_EVENT + appName, true, false, false, QUEUE_ARGS);
    }

    @Bean
    public Binding appEventTopicExchangeBinding(TopicExchange appEventTopicExchange, Queue appEventQueue){
        // rabbitmq-producer.<envent>.<priority>
        // rabbitmq-producer.#
        String routingKey = appName + ".#";
        log.info("appEventQueue binds to appEventTopicExchange with routing key {}",routingKey);
        return BindingBuilder.bind(appEventQueue).to(appEventTopicExchange).with(routingKey);
    }
}
