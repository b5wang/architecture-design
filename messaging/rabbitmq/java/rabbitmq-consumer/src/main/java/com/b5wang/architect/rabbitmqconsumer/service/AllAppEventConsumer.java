package com.b5wang.architect.rabbitmqconsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
//@RabbitListener(queues = "#{appEventAllQueue.name}")
public class AllAppEventConsumer {

    //@RabbitHandler
    public void handle(String msg){
        log.info("All app event: {}", msg);
    }

}
