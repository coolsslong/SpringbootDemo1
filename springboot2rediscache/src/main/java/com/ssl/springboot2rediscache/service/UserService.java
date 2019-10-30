package com.ssl.springboot2rediscache.service;

import com.ssl.springboot2rediscache.entity.Users;
import com.ssl.springboot2rediscache.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
/**
 * 配置公用的缓存配置
 */
//@CacheConfig(cacheNames = "user")

public class UserService {
    @Autowired
    DemoMapper demoMapper;

    @Cacheable(value = "user", cacheManager = "cacheManager")
    public Users findUserById(Integer id) {
        System.out.println("查询" + id + "号用户");
        Users users = demoMapper.findById(id);
        return users;
    }

    @CachePut(value = "user", key = "#result.id")
    public Users updateUser(Users users) {
        demoMapper.updateUser(users);
        return users;
    }


    public void deleteUser(Integer id) {
        demoMapper.deleteUserById(id);
    }

    public void insertUser(Users users) {
        demoMapper.insertUser(users);
    }
}
