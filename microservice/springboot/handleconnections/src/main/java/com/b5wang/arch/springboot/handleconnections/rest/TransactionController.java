package com.b5wang.arch.springboot.handleconnections.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransactionController {

    @GetMapping("/tran")
    public String getTransactions() throws InterruptedException {

        log.info("/tran start");
        Thread.sleep(1000 * 30);
        log.info("/tran end");
        return "OK";
    }


}
