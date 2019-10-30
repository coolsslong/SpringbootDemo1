package com.ssl.demo;

import com.ssl.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("jason", "manyHairs");
        Assert.assertEquals("manyHairs", redisTemplate.opsForValue().get("jason"));
    }

    @Test
    public void testObj() {
        User user = new User("jason", "123456", "male", "xx");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("demo", user);
        User user1 = operations.get("demo");
        System.out.println(user1.toString());
    }

    @Test
    /**
     * 测试超时失效
     */
    public void testExpire() throws InterruptedException {
        User user = new User("jason", "123456", "male", "xx");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("jason", user, 100, TimeUnit.MICROSECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("jason");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    @Test
    public void testHashSet() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key", "field", "value");
        String value = (String) hashOperations.get("key", "field");
        System.out.println("value:" + value);
    }

    @Test
    public void testList() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.rightPush("1", "yi");
        listOperations.rightPush("1", "er");
        listOperations.rightPush("1", "san");
        //String value = listOperations.leftPop("1");
        //System.out.println(value);
        List<String> list = listOperations.range("1", 1, 3);
        for (String s : list) {
            System.out.println("list:" + s);
        }
    }

    @Test
    public void testSet() {
        String key = "set";
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add(key, "123");
        setOperations.add(key, "98");
        setOperations.add(key, "140");
        setOperations.add(key, "130");
        Set<String> values = setOperations.members(key);
        //redisTemplate.delete(key);
        for (String value : values) {
            System.out.println("set:" + value);
        }
    }
}
