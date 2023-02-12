package com.b5wang.elk.logmaker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * */
@Slf4j
@RestController
public class LogMakerController {

    @Autowired
    private LogMakerService logMakerService;

    @GetMapping("/startLogMaker")
    public ResponseEntity<String> startSimpleLogging(@RequestParam String name) throws InterruptedException {
        log.info("start logMaker: {}",name);
        if(name.equalsIgnoreCase("simple")){
            logMakerService.startSimpleLogMaker();
        }

        return ResponseEntity.ok("OK!");
    }

    @GetMapping("/stopLogMaker")
    public ResponseEntity<String> stopSimpleLogging(@RequestParam String name) throws InterruptedException {
        log.info("stop logMaker: {}",name);
        if(name.equalsIgnoreCase("simple")){
            logMakerService.stopSimpleLogMaker();
        }

        return ResponseEntity.ok("OK!");
    }

}
