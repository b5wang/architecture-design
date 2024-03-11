package com.b5wang.architect.springboot.security.webapp.basicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class WebAppBasicAuthApplication {

    public static void main(String[] args){
        SpringApplication.run(WebAppBasicAuthApplication.class,args);
    }

}
