package com.example.consumerservice.common.rabbit;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {

    private static Logger logger = Logger.getLogger(HelloReceive.class);

    //创建消费者，由COLLECT_QUEUE_NAME监听队列
    @RabbitListener(queues="COLLECT_QUEUE_NAME")//监听器监听指定的Queue
    public void process(String str) {
        logger.info("创建消费者，Receive："+str);
    }
}
