package com.ssl.springbootdemo;

import com.ssl.springboot_jdbc.dao.UserDao;
import com.ssl.springboot_jdbc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.ssl.springboot_jdbc.dao")
public class SpringbootDemoApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    public void test() {
        User user = new User("smile", "111", 100);
        userDao.save(user, primaryJdbcTemplate);
        userDao.save(user, secondaryJdbcTemplate);
    }

    @Test
    public void test1() {
        User user = new User("龙俊宇", "123456", 20);
        userDao.save(user);
    }

    @Test
    public void test2() {
        User user = new User(1L, "jason", "123456", 20);
        System.out.println(userDao.update(user));
    }

    @Test
    public void test3() {
        userDao.delete(1L);
    }

    @Test
    public void test4() {
        List list = userDao.findAll();
        System.out.println(list);
    }

    @Test
    public void test5() {
        System.out.println(userDao.findById(3));
    }

//    private MockMvc mockMvc;
//
//
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
//    }
//
//    @Test
//    public void saveUser() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
//                .param("name", "")
//                .param("age", "666")
//                .param("pass", "test"));
//    }


}
