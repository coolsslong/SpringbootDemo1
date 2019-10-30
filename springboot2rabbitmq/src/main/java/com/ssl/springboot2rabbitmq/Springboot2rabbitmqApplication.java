package com.ssl.springboot2rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit//开启基于注解的rabbitmq
@SpringBootApplication
public class Springboot2rabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2rabbitmqApplication.class, args);
    }

}
