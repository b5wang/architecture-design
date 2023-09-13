package com.b5wang.archi.redisjava.service;

import com.b5wang.archi.redisjava.entity.Job;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ListService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @PostConstruct
    public void init(){
    }

}
