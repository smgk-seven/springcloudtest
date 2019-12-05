package com.smgk.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.Msg;
import com.smgk.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired

    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    private Msg add(@RequestBody Dept dept){
            deptService.addDept(dept);
        return Msg.success().add("dept", dept);
    }

    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Msg get(@PathVariable("id") long id){
        Dept dept = deptService.findById(id);
        if (dept == null){
            throw new RuntimeException("");
        }
        return Msg.success().add("dept", dept);
    }

    //如果上面的获取部门出了异常就会进入这个方法
    public Msg processHystrixGet(@PathVariable("id") long id){
        return Msg.fail().add("msg", "not found id in " + id);
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public Msg list(){
        List<Dept> depts = deptService.findAll();
        return Msg.success().add("depts", depts);
    }

    /*@RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        //获取所有的微服务（服务端）
        List<String> services = discoveryClient.getServices();
        System.out.println("System ---> 共有微服务个数：" + services.size());

        //获取指定名称的微服务
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloudtest-dept");
        for (ServiceInstance element :instances){
            System.out.println("System---> " + element.getHost() + "\t" + element.getServiceId() + "\t" + element.getPort() );
        }
        return this.discoveryClient;
    }*/
}
