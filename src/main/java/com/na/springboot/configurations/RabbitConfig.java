package com.na.springboot.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置
 *
 * @author fengna
 * @date 2019/3/4
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue(){

        return new Queue("hello");
    }

}
