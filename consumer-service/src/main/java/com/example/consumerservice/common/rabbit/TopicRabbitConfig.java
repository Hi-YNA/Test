package com.example.consumerservice.common.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    /**
     * @description: 创建配置队列，用来创建其他队列
     * 命名规则：A_TO_B_QUEUE A_TO_B_EXCHANGE (A,B分别为系统A和B)
     */
    @Value("COLLECT_EXCHANGE_LOCAL")
    private String EXCHANGE_NAME; // 交换机名称

    @Value("COLLECT_QUEUE_NAME")
    private String QUEUE_NAME; // 队列名称

    @Value("COLLECT_ROUTING_KEY")
    private String ROUTING_KEY; // RoutingKey

    /** 创建交换机 */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    /** 创建队列 */
    @Bean
    public Queue logCollectQueue() {
        return new Queue(QUEUE_NAME);
    }

    /** 通过routingKey把队列与交换机绑定起来 */
    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
