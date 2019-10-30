package com.ssl.demo.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

@Component
public class Demo2StaticIOC {
    @Resource(name = "mapStatic")
    private Map<String,String> mapxx;

    private static Map<String,String> map;

    @PostConstruct
    public void init() {
        map=mapxx;
    }

    public static void demo() {
        System.out.println(map.toString());
    }
}
