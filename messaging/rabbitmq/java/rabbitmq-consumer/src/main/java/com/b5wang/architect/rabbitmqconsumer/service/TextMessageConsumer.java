package com.b5wang.architect.rabbitmqconsumer.service;

import com.b5wang.architect.rabbitmqconsumer.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_TEXT_MESSAGE, concurrency = "1-1")
public class TextMessageConsumer {

    @RabbitHandler
    public void handle(String msg){
        log.info("Handle message: {}",msg);
        try {
            Thread.sleep(1000*10);// 10 sec
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(msg.contains("error")){
            throw new RuntimeException("Message has error!");
        }
    }
}
