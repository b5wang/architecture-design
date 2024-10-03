package com.b5wang.architect.ratelimiting.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        log.info("Call hello: say hello 1000 times");
        // 1.5.0 版本开始可以直接利用 try-with-resources 特性
        try (Entry entry = SphU.entry("sayHello")) {
            // 被保护的逻辑
            System.out.println("Hello!");
        } catch (BlockException ex) {
            // 处理被流控的逻辑
            System.out.println("blocked!");
        }
        return ResponseEntity.ok("OK");
    }


}
