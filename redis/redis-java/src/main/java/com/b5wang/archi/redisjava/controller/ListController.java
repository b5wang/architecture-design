package com.b5wang.archi.redisjava.controller;

import com.b5wang.archi.redisjava.entity.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/list")
@RestController
public class ListController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @GetMapping("/addJob")
    public ResponseEntity<?> addJob(){
        log.info("/list/save");
        long index = redisTemplate.boundListOps("job_list").rightPush(new Job());
        log.info("/list/save. Added at {}",index);
        return ResponseEntity.ok().build();
    }


}
