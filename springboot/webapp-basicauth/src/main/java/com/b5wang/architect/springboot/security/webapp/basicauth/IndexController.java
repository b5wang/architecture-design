package com.b5wang.architect.springboot.security.webapp.basicauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/public/singup")
    public String home(){
        return "public/signup";
    }

}
