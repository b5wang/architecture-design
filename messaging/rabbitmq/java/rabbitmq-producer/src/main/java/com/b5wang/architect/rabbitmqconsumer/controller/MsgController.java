package com.b5wang.architect.rabbitmqconsumer.controller;

import com.b5wang.architect.rabbitmqconsumer.config.RabbitMQConfig;
import com.b5wang.architect.rabbitmqconsumer.entity.TextMessage;
import com.b5wang.architect.rabbitmqconsumer.entity.TextMessageBatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping(path = "/msg/textMessage")
    public ResponseEntity<?> sendTextMessage(@RequestBody TextMessage textMessage){
        log.info("TextMessage: {}",textMessage.getMsg());
        // Only support string, byte[]
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME_TEXT_MESSAGE,textMessage.getMsg());
        return ResponseEntity.ok("DONE");
    }

    @PostMapping(path = "/msg/textMessageBatch")
    public ResponseEntity<?> sendTextMessageBatch(@RequestBody TextMessageBatch textMessageBatch){
        log.info("TextMessageBatch - total: {}, msg: {}",textMessageBatch.getTotal(),textMessageBatch.getMsg());
        handleTextMessageBatch(textMessageBatch);
        return ResponseEntity.ok("DONE");
    }

    @Async
    private void handleTextMessageBatch(TextMessageBatch textMessageBatch){
        if(textMessageBatch.getTotal() <= 0){
            return;
        }

        for(int i=1; i<=textMessageBatch.getTotal(); i++){
            String textMessage = textMessageBatch.getMsg() + " [" + i + "]";
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME_TEXT_MESSAGE,textMessage);
        }
        log.info("Processed TextMessageBatch - total: {}, msg: {}",textMessageBatch.getTotal(),textMessageBatch.getMsg());
    }

}
