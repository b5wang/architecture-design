package com.b5wang.archi.redisjava.controller;

import com.b5wang.archi.redisjava.entity.DBConfig;
import com.b5wang.archi.redisjava.entity.StringKeyValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/string")
@RestController
public class StringController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    /**
     * By default, request body is json format
     * */
    @PostMapping("/save")
    //@PostMapping(value="/save",produces="application/json;charset=UTF-8")
    public ResponseEntity<?> save(@RequestBody StringKeyValue skv){
        log.info("/string/save key={}, value={}",skv.getKey(),skv.getValue());
        stringRedisTemplate.opsForValue().set(skv.getKey(),skv.getValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="/get",produces="application/json;charset=UTF-8")
    public ResponseEntity<?> get(@RequestBody StringKeyValue skv){
        log.info("/string/get key={}, value={}",skv.getKey(),skv.getValue());
        String value = stringRedisTemplate.opsForValue().get(skv.getKey());
        skv.setValue(value);
        return ResponseEntity.ok(skv);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count(){
        log.info("/string/count");
        //stringRedisTemplate.opsForValue().setIfAbsent("global_count","0");
        Long currentValue = stringRedisTemplate.opsForValue().increment("global_count");
        return ResponseEntity.ok(currentValue);
    }

    @PostMapping("/saveObj")
    public ResponseEntity<?> saveObj(@RequestBody DBConfig dbConfig){
        log.info("/string/saveObj: {}",dbConfig);
        try {
            String jsonStr = jacksonObjectMapper.writeValueAsString(dbConfig);
            log.info("jsonStr: {}",jsonStr);
            stringRedisTemplate.opsForValue().set("dbConfig",jsonStr);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("Failed to save!");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getObj")
    public ResponseEntity<?> saveObj(@RequestParam String key){
        log.info("/string/getObj: {}",key);
        String jsonStr = stringRedisTemplate.opsForValue().get(key);
        log.info("jsonStr: {}",jsonStr);
        if(jsonStr == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
        }

        DBConfig dbConfig = null;
        try {
            dbConfig = jacksonObjectMapper.readValue(jsonStr, DBConfig.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        }

        return ResponseEntity.ok(dbConfig);
    }
}
