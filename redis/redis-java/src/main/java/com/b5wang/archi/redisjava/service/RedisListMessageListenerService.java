package com.b5wang.archi.redisjava.service;

import com.b5wang.archi.redisjava.listener.RedisListMessageListener;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisListMessageListenerService {


    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private RedisListMessageListener redisListMessageListener;

    @PostConstruct
    public void init(){
        log.info("Init redisListMessageListener!");
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(redisListMessageListener, new PatternTopic("job_list"));
        container.start();
    }


}
