package com.b5wang.architect.rabbitmqconsumer.controller;

import com.b5wang.architect.rabbitmqconsumer.config.RabbitMQConfig;
import com.b5wang.architect.rabbitmqconsumer.entity.AppEvent;
import com.b5wang.architect.rabbitmqconsumer.entity.TextMessage;
import com.b5wang.architect.rabbitmqconsumer.entity.TextMessageBatch;
import com.b5wang.architect.rabbitmqconsumer.service.MsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange notificationFanoutExchange;

    @Autowired
    private DirectExchange regionNotificationDirectExchange;

    @Autowired
    private TopicExchange appEventTopicExchange;

    @Autowired
    private MsgService msgService;

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
        msgService.handleTextMessageBatch(textMessageBatch);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping(path = "/msg/notification")
    public ResponseEntity<?> sendNotification(@RequestBody TextMessage notification){
        log.info("Notification: {}",notification.getMsg());
        rabbitTemplate.convertAndSend(notificationFanoutExchange.getName(),"",notification.getMsg());
        return ResponseEntity.ok("DONE");
    }

    @PostMapping(path = "/msg/regionNotification")
    public ResponseEntity<?> sendRegionNotification(@RequestBody TextMessage notification){
        log.info("RegionNotification: msg={}, to={}",notification.getMsg(),notification.getRegion());
        rabbitTemplate.convertAndSend(regionNotificationDirectExchange.getName(),notification.getRegion(),notification.getMsg());
        return ResponseEntity.ok("DONE");
    }

    @PostMapping(path = "/msg/appEvent")
    public ResponseEntity<?> sendAppEvent(@RequestBody AppEvent appEvent){
        log.info("AppEvent: msg={}, to={}.{}.{}",appEvent.getMsg(),appEvent.getApp(),appEvent.getEvent(),appEvent.getPriority());
        String routingKey = appEvent.getApp() + "." + appEvent.getEvent() + "." + appEvent.getPriority();
        rabbitTemplate.convertAndSend(appEventTopicExchange.getName(),routingKey,appEvent.getMsg());
        return ResponseEntity.ok("DONE");
    }
}
