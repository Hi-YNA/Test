package com.example.providerservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
public class ProviderService2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderService2Application.class, args);
    }

}
