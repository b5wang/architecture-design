package com.b5wang.architect.rabbitmqconsumer.service;

import com.b5wang.architect.rabbitmqconsumer.config.RabbitMQConfig;
import com.b5wang.architect.rabbitmqconsumer.entity.TextMessageBatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MsgService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    public void handleTextMessageBatch(TextMessageBatch textMessageBatch){
        if(textMessageBatch.getTotal() <= 0){
            return;
        }

        for(int i=1; i<=textMessageBatch.getTotal(); i++){
            String textMessage = textMessageBatch.getMsg() + " [" + i + "]";
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME_TEXT_MESSAGE,textMessage);
            if(textMessageBatch.getDelay() > 0){
                try {
                    Thread.sleep(textMessageBatch.getDelay());
                } catch (InterruptedException e) {
                    log.error("Failed to sleep",e);
                }
            }
        }
        log.info("Processed TextMessageBatch - total: {}, msg: {}",textMessageBatch.getTotal(),textMessageBatch.getMsg());
    }

}
