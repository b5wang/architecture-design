package com.b5wang.architect.rabbitmqconsumer.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RabbitListener(queues = "#{notificationAnonymousQueue.name}")
public class NotificationConsumer {

    @Autowired
    private Queue notificationAnonymousQueue;

    @PostConstruct
    public void postInit(){
        log.info("Anonymous queue name: {}",notificationAnonymousQueue.name());
    }



    @RabbitHandler
    public void handle(String msg){
        log.info("Notification: {}", msg);
    }
}
