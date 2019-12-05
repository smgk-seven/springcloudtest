package com.smgk.springcloud.service.impl;

import com.smgk.springcloud.dao.DeptDao;
import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public Dept findById(Long deptNo) {
        return deptDao.findById(deptNo);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }


    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }
}
