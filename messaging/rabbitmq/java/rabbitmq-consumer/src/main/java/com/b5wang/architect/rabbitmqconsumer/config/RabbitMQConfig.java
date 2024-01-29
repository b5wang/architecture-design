package com.b5wang.architect.rabbitmqconsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String QUEUE_NAME_STRATEGY_NOTIFICATION = "queue.notification-";

    public static final String QUEUE_NAME_STRATEGY_REGION_NOTIFICATION = "queue.regionNotification-";

    public static final String EXCHANGE_NAME_NOTIFICATION = "exchange.fanout.notification";

    public static final String EXCHANGE_NAME_REGION_NOTIFICATION = "exchange.direct.region.notification";

    public static final String EXCHANGE_NAME_APP_EVENT = "exchange.topic.app.event";

    @Value(value="${server.region}")
    private String serverRegion;

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

    /** ----------------------------------------------------------------------------------------------------------------
     * Define a fan-out exchange.
     * -----------------------------------------------------------------------------------------------------------------
     * */
    @Bean
    public FanoutExchange notificationFanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME_NOTIFICATION);
    }

    @Bean
    public Binding notificationFanoutExchangeBinding(FanoutExchange notificationFanoutExchange,Queue notificationAnonymousQueue) {
        log.info("notificationAnonymousQueue binds to notificationFanoutExchange");
        return BindingBuilder.bind(notificationAnonymousQueue).to(notificationFanoutExchange);
    }

    /** ----------------------------------------------------------------------------------------------------------------
     * Define a direct exchange.
     * -----------------------------------------------------------------------------------------------------------------
     * */
    @Bean
    public Queue regionNotificationAnonymousQueue() {
        log.info("Init regionNotificationAnonymousQueue");
        AnonymousQueue aq = new AnonymousQueue(new Base64UrlNamingStrategy(QUEUE_NAME_STRATEGY_REGION_NOTIFICATION + serverRegion + "-"));
        log.info("Init regionNotificationAnonymousQueue - queue.name: {}", aq.getName());
        return aq;
    }

    @Bean
    public DirectExchange regionNotificationDirectExchange(){
        return new DirectExchange(EXCHANGE_NAME_REGION_NOTIFICATION);
    }

    @Bean
    public Binding regionNotificationFanoutExchangeBinding(DirectExchange regionNotificationDirectExchange,Queue regionNotificationAnonymousQueue) {
        log.info("regionNotificationAnonymousQueue binds to regionNotificationDirectExchange with region {}",serverRegion);
        return BindingBuilder.bind(regionNotificationAnonymousQueue).to(regionNotificationDirectExchange).with(serverRegion);
    }

    /** ----------------------------------------------------------------------------------------------------------------
     * Define a topic exchange.
     * -----------------------------------------------------------------------------------------------------------------
     * */
    @Bean
    public TopicExchange appEventTopicExchange(){
        return new TopicExchange(EXCHANGE_NAME_APP_EVENT);
    }


}
