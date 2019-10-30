package com.ssl.springboot2rabbitmq.servie;

import com.ssl.springboot2rabbitmq.bean.book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    /**
     * 监听消息队列
     * 当有消息时执行方法
     *
     * @param book
     */
    @RabbitListener(queues = "aiguigu.news")
    public void receive(book book) {
        System.out.println("收到消息" + book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
