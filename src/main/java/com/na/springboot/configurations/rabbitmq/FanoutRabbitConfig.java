package com.na.springboot.configurations.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * fanout 配置
 *
 * @author fengna
 * @date 2019/3/4
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue queueA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueB() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue queueC() {
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingQueueA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingQueueB(Queue queueB, FanoutExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange);
    }

    @Bean
    public Binding bindingQueueC(Queue queueC, FanoutExchange exchange) {
        return BindingBuilder.bind(queueC).to(exchange);
    }
}
