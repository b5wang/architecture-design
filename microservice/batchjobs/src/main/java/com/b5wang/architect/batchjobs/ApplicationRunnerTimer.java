package com.b5wang.architect.batchjobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
public class ApplicationRunnerTimer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunnerTimer init...{},{}",args.getSourceArgs(),args.getOptionNames());
        Timer timer = new Timer();
        // task – task to be scheduled.
        // delay – delay in milliseconds before task is to be executed.
        // period – time in milliseconds between successive task executions.
        long delay = 60*1000;
        long period = 60*1000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("Timer 1 is running......");
            }
        },delay,period);

        log.info("ApplicationRunnerTimer init end!");
    }

}
