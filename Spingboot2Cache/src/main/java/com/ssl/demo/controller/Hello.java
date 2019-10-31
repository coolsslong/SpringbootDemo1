package com.ssl.demo.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Cacheable(value = "helloCache")
public class Hello {
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("没有走缓存");
        return "hello " + name;
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        return request.getSession().getAttribute("jason").toString()+"分布式session";
    }

    @RequestMapping("/getSession1")
    public String getSession1(HttpServletRequest request) {
        return request.getSession().getAttribute("water").toString()+"分布式session1";
    }
}
