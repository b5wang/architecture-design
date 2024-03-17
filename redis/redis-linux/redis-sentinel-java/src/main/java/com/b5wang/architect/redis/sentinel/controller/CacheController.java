package com.b5wang.architect.redis.sentinel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CacheController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PutMapping("/cache/kv")
    public ResponseEntity<?> kv(@RequestParam String k,@RequestParam String v){
        redisTemplate.opsForValue().set(k,v);

        String val = redisTemplate.boundValueOps(k).get();
        log.info("Get from redis: {},{}",k,val);
        return ResponseEntity.ok().build();
    }

}
