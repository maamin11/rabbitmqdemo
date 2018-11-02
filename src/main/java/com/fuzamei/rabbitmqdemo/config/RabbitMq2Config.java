package com.fuzamei.rabbitmqdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqdemo
 * @description:
 * @author: Andy
 * @create: 2018-11-01 15:57
 **/
@Configuration
@Slf4j
public class RabbitMq2Config {
    public final static String QUEUE_NAME = "springboot-que1";
    public final static String QUEUE_NAME2 = "springboot-que2";
    public final static String EXCHANGE_TYPE = "springboot-exchange-type";
    public final static String ROUTING_KEY = "quick.orange.rabbit";
    public final static String BINDING_KEY = "*.orange.*";
    public final static String BINDING_KEY1 = "dddd";

    @Bean("que1")
    public Queue queue() {
        log.info("生成一个消息队列");
        return new Queue(QUEUE_NAME);
    }
    @Bean("que2")
    public Queue queue1() {
        log.info("生成一个消息队列");
        return new Queue(QUEUE_NAME2);
    }

    @Bean
    public TopicExchange exchange() {
        log.info("生成一个topic交换机");
        return new TopicExchange(EXCHANGE_TYPE);
    }

    @Bean
    public Binding binding(@Qualifier("que1") Queue queue, TopicExchange exchange) {
        log.info("绑定que1队列到exchage,bindkey为{}",BINDING_KEY);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding binding1(@Qualifier("que2") Queue queue, TopicExchange exchange) {
        log.info("绑定que2队列到exchage,bindkey为{}",BINDING_KEY1);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
