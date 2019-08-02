package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${active}")
    private String active;

    @RequestMapping("/")
    public String hello() {
        System.out.println("--hello--");
        return "==============success-=========" + active;
    }
}
