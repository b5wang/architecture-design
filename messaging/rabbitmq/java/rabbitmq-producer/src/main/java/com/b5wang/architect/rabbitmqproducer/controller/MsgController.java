package com.b5wang.architect.rabbitmqproducer.controller;

import com.b5wang.architect.rabbitmqproducer.entity.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MsgController {

    @PostMapping(path = "/msg/sendText")
    public ResponseEntity<?> sendTextMessage(@RequestBody TextMessage msg){
        log.info("Text msg: {}",msg.getMsg());
        return ResponseEntity.ok().build();
    }

}
