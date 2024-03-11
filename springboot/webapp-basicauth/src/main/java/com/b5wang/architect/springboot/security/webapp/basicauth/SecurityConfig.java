package com.b5wang.architect.springboot.security.webapp.basicauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/admin/**").hasRole("Admin")
//                        .requestMatchers("/customer/**").hasRole("Customer")
//                        .anyRequest().authenticated()
//                );
//
//        httpSecurity.authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//        ).httpBasic(withDefaults());
//
//        return httpSecurity.build();
//    }

}
