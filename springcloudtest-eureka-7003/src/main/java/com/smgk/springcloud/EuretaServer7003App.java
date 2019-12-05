package com.smgk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EuretaServer7003App {
    public static void main(String[] args){
        SpringApplication.run(EuretaServer7003App.class, args);
    }
}
