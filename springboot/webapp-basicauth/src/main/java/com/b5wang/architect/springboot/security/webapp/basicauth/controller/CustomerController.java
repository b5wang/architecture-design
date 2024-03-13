package com.b5wang.architect.springboot.security.webapp.basicauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer/account")
    public String account(){
        return "customer/account";
    }

}
