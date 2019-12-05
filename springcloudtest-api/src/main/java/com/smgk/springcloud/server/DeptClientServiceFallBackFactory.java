package com.smgk.springcloud.server;

import com.smgk.springcloud.entities.Dept;
import com.smgk.springcloud.entities.Msg;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Msg addDept(Dept deptEntity) {
                return Msg.fail().add("Dept", deptEntity).add("msg", "不能添加相同名字的部门");
            }

            @Override
            public Msg findById(Long deptNo) {
                return Msg.fail().add("msg", "new not found dpet to id in " + deptNo);
            }

            @Override
            public Msg findAll() {
                return null;
            }
        };
    }
}
