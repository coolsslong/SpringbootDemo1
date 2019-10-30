package com.ssl.demo;

import com.ssl.demo.util.Demo2StaticIOC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource(name = "mapStatic")
    private Map<String, String> map;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        System.out.println(map.toString());
        System.out.println(map.get("ID").getClass());
        Demo2StaticIOC.demo();
    }

    @Test
    public void test1() {
        System.out.println("demo");
    }
}
