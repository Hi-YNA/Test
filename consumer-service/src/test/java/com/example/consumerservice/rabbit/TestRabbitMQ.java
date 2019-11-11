package com.example.consumerservice.rabbit;

import com.example.consumerservice.ConsumerServiceApplication;
import com.example.consumerservice.common.rabbit.HelloSender;
import com.example.consumerservice.common.rabbit.HelloSender2;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes= ConsumerServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {

    private static Logger logger = Logger.getLogger(TestRabbitMQ.class);

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloSender2 helloSender2;

    @Test
    public void testRabbit() {
        logger.info("start");
        helloSender.send();
        logger.info("end");
    }
}
