package com.smgk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.smgk.springcloud")
@ComponentScan("com.smgk.springcloud")
public class ApplicationConsumerFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsumerFeignApp.class,args);
    }
}
