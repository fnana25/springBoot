package com.na.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收
 *
 * @author fengna
 * @date 2019/3/4
 */
@Slf4j
@Component
@RabbitListener(queues = "hello")
public class RabbitReceiver1 {

    @RabbitHandler
    public void receive(String context){
        log.info("receive1 : {}",context);
    }
}
