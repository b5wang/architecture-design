package com.b5wang.architect.samples.ebank.business.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProbeController {

    @GetMapping("/probe/startup")
    public ResponseEntity<?> startup(){
        log.info("startupProbe");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/probe/liveness")
    public ResponseEntity<?> liveness(){
        log.info("livenessProbe");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/probe/readiness")
    public ResponseEntity<?> readiness(){
        log.info("readinessProbe");
        return ResponseEntity.ok().build();
    }
}
