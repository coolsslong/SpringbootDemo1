package com.ssl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssl.mapper.UserMapper;
import com.ssl.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        //增加
        for (int i = 0; i < 100; i++) {
            User user = new User("ruiwen"+i, "123456", "女", "xxx");
            userMapper.insert(user);
        }
        //查询
//        System.out.println(userMapper.getAll());
//        //测试缓存，一级缓存默认开启，同一个查询拿到的对象是一样的
//        System.out.println(userMapper.getOne(1L)==userMapper.getOne(1L));
//        user.setNickName("mmmmm");
//        user.setId(2L);
//        userMapper.update(user);
//        userMapper.delete(1L);
    }

    @Test
    public void test1() {
        Page<Object> page = PageHelper.startPage(2, 10);
        userMapper.getAll().forEach(user -> System.out.println(user));
        PageInfo<Object> pageInfo = new PageInfo<>();
        System.out.println("page.getPageNum() = " + page.getPageNum());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getPageSize() = " + page.getPageSize());
        System.out.println("page.getPages() = " + page.getPages());
    }

    @Test
    public void test2() {

    }
}
