package com.smgk.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.smgk.springcloud.dao")
public class DeptProvider8001_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
