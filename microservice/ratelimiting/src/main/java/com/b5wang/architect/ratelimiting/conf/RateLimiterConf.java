package com.b5wang.architect.ratelimiting.conf;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimiterConf {

    @Bean
    public RateLimiter greetingRateLimiter(){
        // Token bucket, 0.5 token per second
        return RateLimiter.create(0.5);
    }

}
