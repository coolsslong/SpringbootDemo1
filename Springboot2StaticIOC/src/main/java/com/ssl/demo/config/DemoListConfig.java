package com.ssl.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:config/listioc.properties", encoding = "utf-8")
@ConfigurationProperties(prefix = "demo")
public class DemoListConfig {
    private Map<String, String> map = new HashMap<>();

    public DemoListConfig() {
    }

    @Bean(name = "mapStatic")
    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
