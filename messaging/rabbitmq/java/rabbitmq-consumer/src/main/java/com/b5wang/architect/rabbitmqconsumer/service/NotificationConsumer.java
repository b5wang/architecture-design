package com.b5wang.architect.rabbitmqconsumer.service;

import com.b5wang.architect.rabbitmqconsumer.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RabbitListener(queues = "#{notificationAnonymousQueue.name}")
public class NotificationConsumer {

    @RabbitHandler
    public void handle(String msg){
        log.info("Notification: {}", msg);
    }
}
