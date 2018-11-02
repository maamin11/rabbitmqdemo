package com.fuzamei.rabbitmqdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqdemo
 * @description: 定义一个消费者
 * @author: Andy
 * @create: 2018-10-31 16:42
 **/
@Configuration
@RabbitListener(queues = "maaminQue1")
@Slf4j
public class Receiver1 {
    @RabbitHandler
    public void receiver(String msg) {
        log.info("消费者Receiver1接受到的消息："+msg);
    }

}
