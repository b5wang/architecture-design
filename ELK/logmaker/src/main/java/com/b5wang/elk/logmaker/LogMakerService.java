package com.b5wang.elk.logmaker;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class LogMakerService {

    private static boolean FLAG_SIMPLE_LOG_RUNNING = false;

    @Async("logMakerThreadPool")
    public void startSimpleLogMaker() throws InterruptedException {
        FLAG_SIMPLE_LOG_RUNNING = true;

        log.info("threadName: {}, currentTime: {}, logMaker started", Thread.currentThread().getName(), new Date());

        while(FLAG_SIMPLE_LOG_RUNNING){
            log.info("threadName: {}, currentTime: {}", Thread.currentThread().getName(), new Date());
            Thread.sleep(2000);
        }

        log.info("threadName: {}, currentTime: {}, logMaker finished", Thread.currentThread().getName(), new Date());
    }

    public void stopSimpleLogMaker(){
        FLAG_SIMPLE_LOG_RUNNING = false;
    }



}
