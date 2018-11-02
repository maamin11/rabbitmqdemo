package com.fuzamei.rabbitmqdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqdemo
 * @description: 消息队列的配置类
 * @author: Andy
 * @create: 2018-10-31 16:34
 **/
@Configuration
@Slf4j
public class RabbitMqConfig {
    @Bean
    public Queue queue1() {
        log.info(">>>>>>>>>创建消息队里queue1>>>>>>>>>>>>");
        return new Queue("maaminQue1");
    }

}
