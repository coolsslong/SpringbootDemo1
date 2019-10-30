package com.ssl.springboot2rediscache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 开启缓存和mapper包扫描
 */
@EnableCaching
@MapperScan("com.ssl.springboot2rediscache.mapper")
@SpringBootApplication
public class Springboot2rediscacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2rediscacheApplication.class, args);
    }
}
