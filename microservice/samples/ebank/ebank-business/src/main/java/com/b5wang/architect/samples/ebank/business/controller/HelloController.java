package com.b5wang.architect.samples.ebank.business.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Value("${test.arg1}")
    private String arg1;

    @Value("${test.arg2}")
    private String arg2;

    @GetMapping("/hello")
    public ResponseEntity hello(){
        log.info("say Hello! arg1={},arg2={}",arg1,arg2);
        return ResponseEntity.ok("Hello!");
    }

}
