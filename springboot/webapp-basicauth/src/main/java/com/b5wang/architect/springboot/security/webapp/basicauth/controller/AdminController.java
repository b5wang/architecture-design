package com.b5wang.architect.springboot.security.webapp.basicauth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/management")
    public String management(){
        return "admin/management";
    }

}
