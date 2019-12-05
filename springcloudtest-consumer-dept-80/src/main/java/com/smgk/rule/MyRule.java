package com.smgk.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class MyRule {
    @Bean
    public IRule myTestRule(){
        //return new RoundRobinRule();
        return new MyRandonRule();
    }
}
