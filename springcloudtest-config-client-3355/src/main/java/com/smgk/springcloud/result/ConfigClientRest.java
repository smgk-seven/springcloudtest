package com.smgk.springcloud.result;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){

        String str = "applicationName:"+this.applicationName
                +"port:"+this.port;
        System.out.println(str);
        return str;
    }
}
