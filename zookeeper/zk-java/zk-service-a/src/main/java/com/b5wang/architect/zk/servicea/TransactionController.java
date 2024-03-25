package com.b5wang.architect.zk.servicea;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransactionController {

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(){
        return ResponseEntity.ok().build();
    }

}
