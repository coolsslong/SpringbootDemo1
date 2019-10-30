package com.ssl.springboot2rediscache.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * 配置缓存主键生成策略，默认使用的是参数名
 */
@Configuration
public class CacheConfig extends CachingConfigurerSupport {
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder builder = new StringBuilder();
                builder.append(o.getClass().getName());
                builder.append(method.getName());
                for (Object object : objects) {
                    builder.append(object);
                }
                return builder.toString();
            }
        };
    }
    /*
    @Bean
    public RedisCacheManager cacheManager() {

    }
*/
}
