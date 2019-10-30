package com.ssl;

import com.ssl.dao.UserRepository;
import com.ssl.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        //创建日期格式
        //2019年8月9日 下午05时41分02秒
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa", "aa@126.com", "aa", "aa123456", formattedDate));
        userRepository.save(new User("bb", "bb@126.com", "bb", "bb123456", formattedDate));
        userRepository.save(new User("cc", "cc@126.com", "cc", "cc123456", formattedDate));

        // Assert.assertEquals(9, userRepository.findAll().size());
        //Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com"));
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
