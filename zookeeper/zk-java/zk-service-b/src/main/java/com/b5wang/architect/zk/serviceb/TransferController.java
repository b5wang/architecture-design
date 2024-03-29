package com.b5wang.architect.zk.serviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransferController {

    @GetMapping("/test")
    public ResponseEntity<?> transfer(){
        log.info("Get request");
        return ResponseEntity.ok("DONE!");
    }


}
