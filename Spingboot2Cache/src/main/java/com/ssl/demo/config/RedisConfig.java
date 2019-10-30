package com.ssl.demo.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置主键的生产策略
 * 不配置会默认使用参数名作为主键
 * 注意，我们使⽤了注解：@EnableCaching 来开启缓存。
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * watermelon
     *
     */

    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object object : objects) {
                sb.append(object.toString());
            }
            System.out.println("water");
            return sb.toString();
        };
    }
}
