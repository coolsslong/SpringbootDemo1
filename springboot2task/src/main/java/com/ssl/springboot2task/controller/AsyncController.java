package com.ssl.springboot2task.controller;

import com.ssl.springboot2task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("name", "jason");
        map.put("password", "123456");
        return "success";
    }
}
