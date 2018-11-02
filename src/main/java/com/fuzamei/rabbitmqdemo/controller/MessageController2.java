package com.fuzamei.rabbitmqdemo.controller;

import com.fuzamei.rabbitmqdemo.config.RabbitMq2Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqdemo
 * @description:
 * @author: Andy
 * @create: 2018-11-01 15:54
 **/
@RestController
@RequestMapping(value = "/message2")
@Slf4j
public class MessageController2 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/send")
    public String send() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>.发送消息>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String value = "message"+(i+1);
                // 将消息发送到交换机
                rabbitTemplate.convertAndSend(RabbitMq2Config.EXCHANGE_TYPE, RabbitMq2Config.ROUTING_KEY,value);
            }
        }).start();
        return "消息发送成功";
    }
}
