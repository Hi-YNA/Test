package com.example.providerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloProviderController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello,I am num one provider,nice to meet you!";
    }
}
