package com.ssl.springboot2task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2taskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮件任务");
        message.setText("ikun-马孝权");
        message.setTo("310738993@qq.com");
        message.setTo("1208128037@qq.com");
        message.setFrom("1452844985@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws MessagingException {
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("通知-下班了，各位老铁");
        helper.setText("<b style='color:red'>冲冲冲</b>", true);
        //上传文件
        helper.addAttachment("1.jpg", new File("图片路径"));
        helper.setTo("接收方邮箱账号");
        helper.setFrom("发送方邮箱账号");//需要和配置文件中保持一致
        mailSender.send(mimeMessage);
    }

}
