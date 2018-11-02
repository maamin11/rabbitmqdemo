package com.fuzamei.rabbitmqdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqdemo
 * @description: 发送消息的controller
 * @author: Andy
 * @create: 2018-10-31 16:23
 **/
@RestController
@RequestMapping(value = "/message")
public class MessageController {
    private Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/send")
    public String send() {
        logger.info(">>>>>>>>>>>>>>>>>>>发送消息>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //发送10条消息给maaminQue1队列
        for (int i = 1; i < 10; i++) {
            amqpTemplate.convertAndSend("maaminQue1","你好啊"+i);
        }
        return "消息发送成功";
    }
}
