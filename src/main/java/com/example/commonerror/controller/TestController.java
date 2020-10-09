package com.example.commonerror.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test1")
    public String test1(){
        throw new RuntimeException("抛出异常");
    }
}
