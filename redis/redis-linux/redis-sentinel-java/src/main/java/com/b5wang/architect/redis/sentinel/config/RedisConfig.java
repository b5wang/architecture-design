package com.b5wang.architect.redis.sentinel.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * No need do any config for sentinel.
 *
 * https://docs.spring.io/spring-data/redis/reference/redis/connection-modes.html
 * https://stackoverflow.com/questions/42088184/redis-sentinel-set-up-with-spring-boot
 *
 * This is correct:
 * https://medium.com/javarevisited/caching-with-spring-boot-3-lettuce-and-redis-sentinel-5f6fab7e58f8
 * */

@Slf4j
@Configuration
public class RedisConfig {

}
