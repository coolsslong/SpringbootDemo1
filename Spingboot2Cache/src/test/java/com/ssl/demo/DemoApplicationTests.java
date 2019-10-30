package com.ssl.demo;

import com.ssl.demo.controller.Hello;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(new Hello()).build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        String string = "jason";
        System.out.println(string.isEmpty());
        System.out.println(StringUtils.abbreviate(string, 5));
        System.out.println(StringUtils.endsWith(string, "son"));
    }

    @Test
    public void test1() throws Exception {

        System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/hello")));
        //System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/hello")));

    }
}
