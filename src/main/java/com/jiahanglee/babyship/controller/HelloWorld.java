package com.jiahanglee.babyship.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/hello")
    public static String test(){
        return "hello world!!!5555ere55";
    }
}
