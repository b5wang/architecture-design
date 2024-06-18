package com.b5wang.architect.samples.ebank.business.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity hello(){
        log.info("say Hello!");
        return ResponseEntity.ok("Hello!");
    }

}
