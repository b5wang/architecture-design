package com.b5wang.architect.rabbitmqconsumer.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_TEXT_MESSAGE = "queue.textMessage";

    public static final String QUEUE_NAME_APP_EVENT = "queue.appEvent.";

    public static final String EXCHANGE_NAME_NOTIFICATION = "exchange.fanout.notification";

    public static final String EXCHANGE_NAME_REGION_NOTIFICATION = "exchange.direct.region.notification";

    public static final String EXCHANGE_NAME_APP_EVENT = "exchange.topic.app.event";


    @Value(value = "${spring.application.name}")
    private String appName;

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

    @Bean
    public TopicExchange appEventTopicExchange(){
        return new TopicExchange(EXCHANGE_NAME_APP_EVENT);
    }

    /**
     * Bind the queue to appEventTopicExchange
     * */
    @Bean
    public Queue appEventQueue(){
        return new Queue(QUEUE_NAME_APP_EVENT + appName);
    }

    @Bean
    public Binding appEventTopicExchangeBinding(TopicExchange appEventTopicExchange, Queue appEventQueue){
        String bindingKey = appName + ".#";
        log.info("appEventQueue binds to appEventTopicExchange with routing key {}",bindingKey);
        return BindingBuilder.bind(appEventQueue).to(appEventTopicExchange).with(bindingKey);
    }
}
