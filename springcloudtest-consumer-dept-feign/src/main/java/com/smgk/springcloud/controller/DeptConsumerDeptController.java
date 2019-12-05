package com.smgk.springcloud.controller;

import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.Msg;
import com.smgk.springcloud.server.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptConsumerDeptController {

   @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public Msg add(Dept dept){
        return  deptClientService.addDept(dept);
    }

    @RequestMapping( value = "/consumer/dept/{deptNo}", method = RequestMethod.GET)
    public Msg findById(@PathVariable("deptNo") Long deptNo){
        return deptClientService.findById(deptNo);
    }
    @RequestMapping( value = "/consumer/dept/test", method = RequestMethod.GET)
    public Msg findByIda(Long deptNo){
        return deptClientService.findById(deptNo);
    }

    @RequestMapping("/consumer/dept")
    public Msg findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.findAll();
    }

}
