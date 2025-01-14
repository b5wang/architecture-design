package com.b5wang.architect.batchjobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CommandLineRunnerTimer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunnerTimer init...{},{}",args, Arrays.toString(args));

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        int delay = 60;
        int period = 60;
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("Timer 2 is running......");
            }
        },delay,period,TimeUnit.SECONDS);

        log.info("CommandLineRunnerTimer init end!");
    }
}
