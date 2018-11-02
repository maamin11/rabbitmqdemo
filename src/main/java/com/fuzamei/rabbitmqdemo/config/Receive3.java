package com.fuzamei.rabbitmqdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqdemo
 * @description:
 * @author: Andy
 * @create: 2018-11-01 16:22
 **/
@Configuration

@Slf4j
public class Receive3 {
    @RabbitListener(queues = RabbitMq2Config.QUEUE_NAME)
    public void receive3(String message) {
       log.info("Receive3消费{}",message);
    }
}
