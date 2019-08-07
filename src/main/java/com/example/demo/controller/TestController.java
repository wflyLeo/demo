package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class TestController {


    @Value("${active}")
    private String active;

    @RequestMapping("/test")
    public String test() {
        System.out.println("--hello--");
        return "==============test-=========";
    }

    @RequestMapping("/")
    public String hello() {
        System.out.println("--hello--");
        return "==============success-=========";
    }

    @RolesAllowed({"other"})
    @RequestMapping("/test1/t1")
    public String test11() {
        System.out.println("--hello--");
        return "==============test1/t1-=========";
    }

    @PreAuthorize("hasRole('simple_manage')")
    @RequestMapping("/test1/t2")
    public String test12() {
        System.out.println("--hello--");
        return "==============test1/t2-=========";
    }

    @PreAuthorize("hasRole('other')")
    @RequestMapping("/test1/t3")
    public String test13() {
        System.out.println("--hello--");
        return "==============test1/t3-=========";
    }

    @RequestMapping("/test2/t1")
    public String test21() {
        System.out.println("--hello--");
        return "==============test2/t1-=========";
    }

    @PreAuthorize("hasRole('other')")
    @RequestMapping("/test2/t2")
    public String test22() {
        System.out.println("--hello--");
        return "==============test2/t2-=========";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/test2/t3")
    public String test23() {
        System.out.println("--hello--");
        return "==============/test2/t3=========";
    }

}
