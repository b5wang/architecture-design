package com.b5wang.architect.ratelimiting.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

    @Autowired
    private RateLimiter greetingRateLimiter;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        log.info("Call hello");
        // 1.5.0 版本开始可以直接利用 try-with-resources 特性
        try (Entry entry = SphU.entry("sayHello")) {
            // 被保护的逻辑
            System.out.println("Hello!");
        } catch (BlockException ex) {
            // 处理被流控的逻辑
            System.out.println("blocked!");
        }
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/byebye")
    public ResponseEntity<String> sayByebye(){
        log.info("Call bye bye");

        // 匀速执行10次
        for(int i=0; i < 10; i++){
            while(true) {
                if (greetingRateLimiter.tryAcquire()) {
                    log.info("Handle: " + i);
                    break;
                }
            }
        }

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/addKeyAndValue")
    public ResponseEntity<String> addKeyAndValue(@RequestParam String key,@RequestParam String value){
        log.info("Set into redis, key: {}, value: {}",key,value);
        try{
            redisTemplate.opsForValue().set(key,value);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return ResponseEntity.ok("OK");
    }

}
