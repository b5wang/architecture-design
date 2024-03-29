package com.b5wang.architect.zk.serviceb;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("zk-service-a")
public interface ZkServiceAClient {

    @GetMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_VALUE})
    String test();

}
