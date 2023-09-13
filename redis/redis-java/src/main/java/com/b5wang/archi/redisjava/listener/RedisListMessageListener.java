package com.b5wang.archi.redisjava.listener;

import com.b5wang.archi.redisjava.entity.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class RedisListMessageListener implements MessageListener {

    @Autowired
    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Now message: {}",(Job)jackson2JsonRedisSerializer.deserialize(message.getBody()));
    }
}
