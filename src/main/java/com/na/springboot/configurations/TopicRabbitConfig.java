package com.na.springboot.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic队列配置
 *
 * @author fengna
 * @date 2019/3/4
 */
@Configuration
public class TopicRabbitConfig {

    private final static String MESSAGE = "na.message";
    private final static String MESSAGES = "na.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.MESSAGE);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.MESSAGES);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("na");
    }

    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {

        return BindingBuilder.bind(queueMessage).to(exchange).with("na.message");
    }

    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {

        return BindingBuilder.bind(queueMessages).to(exchange).with("na.#");
    }
}
