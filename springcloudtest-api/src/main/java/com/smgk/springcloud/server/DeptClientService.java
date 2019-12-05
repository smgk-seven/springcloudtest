package com.smgk.springcloud.server;

import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.Msg;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SPRINGCLOUDTEST-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService{

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    Msg addDept(Dept deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    @RequestMapping(value = "/dept/{deptNo}", method = RequestMethod.GET)
    Msg findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "/dept",method = RequestMethod.GET)
    Msg findAll();
}
