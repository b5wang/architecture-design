package com.b5wang.architect.zk.servicea;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransactionController {

    @Autowired
    private ZkServiceBClient zkServiceBClient;


    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(){
        String resp = zkServiceBClient.test();
        log.info("resp: {}",resp);
        return ResponseEntity.ok().build();
    }

}
