package com.ssl.springboot2thymeleaf.controller;

import com.ssl.springboot2thymeleaf.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/string")
    public String thymeleaf(Model map) {
        map.addAttribute("name", "demo");
        map.addAttribute("password", "110");
        return "string";
    }

    @RequestMapping("/if")
    public String ifUnless(ModelMap modelMap) {
        modelMap.put("flag", "yes");
        return "if";
    }

    @RequestMapping("/for")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }
    private  List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("⼤⽜","nan",1);
        User user2=new User("⼩⽜","nv",2);
        User user3=new User("纯洁的微笑","xxx",3);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }



}

