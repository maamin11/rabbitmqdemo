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
public class Receive4 {
    @RabbitListener(queues = RabbitMq2Config.QUEUE_NAME2)
    public void receive4(String message) {
       log.info("Receive4消费{}",message);
    }
}
