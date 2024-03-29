package com.b5wang.architect.zk.servicea;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("zk-service-b")
public interface ZkServiceBClient {

    @GetMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_VALUE})
    String test();

}
