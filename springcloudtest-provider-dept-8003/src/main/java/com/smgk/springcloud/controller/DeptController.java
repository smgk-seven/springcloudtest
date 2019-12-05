package com.smgk.springcloud.controller;

import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.Msg;
import com.smgk.springcloud.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public Msg add(@RequestBody Dept dept){
        if ("报错部门".equals(dept.getDeptName())){
            throw new RuntimeException("添加部门出错");
        }
        deptService.addDept(dept);

        return Msg.success().add("dept", dept);
    }

    @RequestMapping(value = "/dept/{deptNo}", method = RequestMethod.GET)
    public Msg get(@PathVariable("deptNo") Long deptNo){
        Dept dept = deptService.findById(deptNo);
        return Msg.success().add("dept", dept);
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public Msg list(){
        List<Dept> depts = deptService.findAll();
        return Msg.success().add("depts", depts);
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        //获取所有的微服务（服务端）
        List<String> services = discoveryClient.getServices();
        logger.info("logger ---> 共有微服务个数：" + services.size());
        System.out.println("System ---> 共有微服务个数：" + services.size());

        //获取指定名称的微服务
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloudtest-dept");
        for (ServiceInstance element :instances){
            System.out.println("System---> " + element.getHost() + "\t" + element.getServiceId() + "\t" + element.getPort() );
            logger.info("logger---> " + element.getHost() + "\t" + element.getServiceId() + "\t" + element.getPort() );
        }
        return this.discoveryClient;
    }
}
