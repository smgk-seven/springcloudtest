package com.smgk.springcloud;

import com.smgk.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUDTEST-DEPT", configuration = MyRule.class) //标明使用指定的微服务使用指定的分配机构
public class ApplicationConsumer80App {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsumer80App.class,args);
    }
}
