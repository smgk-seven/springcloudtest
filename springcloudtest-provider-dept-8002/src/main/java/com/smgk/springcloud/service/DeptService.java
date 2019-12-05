package com.smgk.springcloud.service;

import com.smgk.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    Dept findById(Long deptNo);

    List<Dept> findAll();

    void addDept(Dept dept);
}
