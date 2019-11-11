package com.example.consumerservice.common.rabbit;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    private static Logger logger = Logger.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate template;

    @Value("COLLECT_EXCHANGE_LOCAL")
    private String EXCHANGE_NAME;  //交换机名字

    @Value("COLLECT_ROUTING_KEY")
    private String ROUTING_KEY; // RoutingKey

    @Value("COLLECT_QUEUE_NAME")
    private String QUEUE_NAME; // 队列名称

    //创建生产者
    public void send() {
        /*//指定交换机和RoutingKey创建生产者
        template.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "hello,rabbit~");*/

        logger.info("创建生产者");
        //根据队列名创建生产者
        template.convertAndSend(QUEUE_NAME,"hello,rabbitQueueName");
    }
}
