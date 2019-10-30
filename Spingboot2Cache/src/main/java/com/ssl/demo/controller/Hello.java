package com.ssl.demo.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Cacheable(value = "helloCache")
public class Hello {
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("没有走缓存");
        return "hello " + name;
    }
}
