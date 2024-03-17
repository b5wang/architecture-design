package com.b5wang.architect.redis.sentinel.springboot.restful.basicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BasicAuthApplication {

    public static void main(String[] args){
        SpringApplication.run(BasicAuthApplication.class,args);
    }

}
