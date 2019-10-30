package com.ssl.springboot2task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//基于注解的定时任务
@EnableAsync//基于注解的异步任务
@SpringBootApplication
public class Springboot2taskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2taskApplication.class, args);
    }

}
