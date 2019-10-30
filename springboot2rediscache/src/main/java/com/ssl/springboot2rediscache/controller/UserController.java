package com.ssl.springboot2rediscache.controller;

import com.ssl.springboot2rediscache.entity.Users;
import com.ssl.springboot2rediscache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/find/{id}")
    public Users findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/update")
    public Users updateUser(Users users) {
        Users user = userService.updateUser(users);
        return user;
    }


    @GetMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/insert")
    public void insertUser(Users users) {
        userService.insertUser(users);
    }
}
