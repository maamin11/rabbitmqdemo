package com.fuzamei.rabbitmqdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqdemo
 * @description: 消费者2
 * @author: Andy
 * @create: 2018-11-01 14:47
 **/
@Configuration
@RabbitListener(queues ="maaminQue1")
@Slf4j
public class Receiver2 {
    @RabbitHandler
    public void receive2(String message) {
        log.info("消费者Receiver2接收到的消息："+message);
    }
}
