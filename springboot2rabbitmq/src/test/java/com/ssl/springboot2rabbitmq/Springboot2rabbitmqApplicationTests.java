package com.ssl.springboot2rabbitmq;

import com.ssl.springboot2rabbitmq.bean.book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2rabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;


    @Test
    public void createExchange() {
        //创建交换器
        amqpAdmin.declareExchange(new DirectExchange("jason.exchange"));
        System.out.println("创建完成");

        //创建队列
        amqpAdmin.declareQueue(new Queue("jason.queue", true));

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("jason.queue", Binding.DestinationType.QUEUE,"jason.exchange","jason.haha",null));
    }

    /**
     * 单播
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造；定义消息体内容和消息体
        //rabbitTemplate.send(exchange,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("hello world", 123, true));
        //对象默认被序列化后发送，默认使用的是jdk序列化
        rabbitTemplate.convertAndSend("exchange.direct", "aiguigu.news", map);
    }

    //接收数据
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("aiguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播模式发送消息
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new book("冲冲冲","xxx"));
    }
}
