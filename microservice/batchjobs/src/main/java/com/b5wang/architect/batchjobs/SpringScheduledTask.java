package com.b5wang.architect.batchjobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringScheduledTask {


    // cron time format
    // (1)second (2)minute (3)hour (4)day(of month) (5)month (6)day(of week)
    @Scheduled(cron = "*/30 * * * * ?")
    public void scheduledTask(){
        log.info("Timer 3 is running.......");
    }

}
