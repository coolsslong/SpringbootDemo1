package com.ssl.springboot2rediscache;

import com.ssl.springboot2rediscache.entity.Users;
import com.ssl.springboot2rediscache.mapper.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2rediscacheApplicationTests {
    @Autowired
    DemoMapper demoMapper;
    @Autowired
    RedisTemplate redisTemplate;
    //操作k-v都是字符串的
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier(value = "usersRedisTemplate")
    RedisTemplate usersRedisTemplate;

    @Test
    public void contextLoads() {
        System.out.println(demoMapper.findById(2));
    }

    /**
     * 测试能否从redis缓存中取出缓存的user用户
     */
    @Test
    public void test1() {
        ValueOperations<String, Users> operations = redisTemplate.opsForValue();
        //operations.set("user",demoMapper.findById(2));
        System.out.println(operations.get("user"));
        usersRedisTemplate.opsForValue().set("user-01",demoMapper.findById(2));

    }
}
