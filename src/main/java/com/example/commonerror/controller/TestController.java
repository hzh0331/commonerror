package com.example.commonerror.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        throw new RuntimeException("不能为负数");
//        return "test";
    }
}
