package com.example.consumerservice.test;

import com.example.consumerservice.ConsumerServiceApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@SpringBootTest(classes= ConsumerServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

    @org.junit.Test
    public void test() {
        String s = "1234";
        System.out.println(Optional.ofNullable(s).orElse("").length());
    }
}
