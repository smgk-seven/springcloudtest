package com.smgk.springcloud.controller;

import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptConsumerDeptController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DEPT_SERVICE_PREFIX = "http://SPRINGCLOUDTEST-DEPT";

    /**
     * 添加一个部门
     * @param dept
     * @return
     */
    @RequestMapping(value = "/consumer/dept/add")
    public Msg add(Dept dept){
        return restTemplate.postForObject(DEPT_SERVICE_PREFIX + "/dept/add", dept, Msg.class);
    }

    /** 通过id获取部门
     * getForObject(请求服务端的地址，返回类型)
     * @param id
     * @return
     */
    @RequestMapping(value = "/consumer/dept/{id}")
    public Msg get(@PathVariable("id") Long id){
        return restTemplate.getForObject(DEPT_SERVICE_PREFIX + "/dept/"+ id, Msg.class);
    }

    @RequestMapping(value = "/consumer/dept")
    public Msg list(){
        return restTemplate.getForObject(DEPT_SERVICE_PREFIX + "/dept", Msg.class);
    }

    //获取服务端的信息
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                DEPT_SERVICE_PREFIX + "/dept/discovery",
                Object.class);
    }
}
