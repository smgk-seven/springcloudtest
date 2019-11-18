package com.smgk.springcloud.controller;

import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.LeeJSONResult;
import com.smgk.springcloud.entities.Msg;
import com.smgk.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public Msg add(@RequestBody Dept dept){
        try{
            if (dept == null){
                throw new RuntimeException("dept 为空");
            }
            deptService.addDept(dept);
        }catch (Exception e){
            return Msg.fail();
        }
        return Msg.success().add("dept", dept);
    }

    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    public Msg get(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        return Msg.success().add("dept", dept);
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public Msg list(){
        List<Dept> depts = deptService.findAll();
        return Msg.success().add("depts", depts);
    }
}
