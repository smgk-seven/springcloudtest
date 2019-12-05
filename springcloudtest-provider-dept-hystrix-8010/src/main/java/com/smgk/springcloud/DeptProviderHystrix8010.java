package com.smgk.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//本服务启动后会自动注册进eureka服务
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan(basePackages = "com.smgk.springcloud.dao")
public class DeptProviderHystrix8010 {
    public static void main(String[] args){
        SpringApplication.run(DeptProviderHystrix8010.class, args);
    }
}
