package com.example.consumerservice.common.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate template;

    @Value("COLLECT_QUEUE_NAME")
    private String QUEUE_NAME; // 队列名称

    //创建生产者
    public void send() {
        //根据队列名创建生产者
        template.convertAndSend(QUEUE_NAME,"hello,rabbitQueueName2");
    }

}
