package com.smgk.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRandonRule extends AbstractLoadBalancerRule {

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    //服务器调用的次数
    private int total = 0;
    //当前服务器数组的索引
    private int currentIndex = 0;
    public Server choose(ILoadBalancer lb, Object key){
        if (lb == null){
            return null;
        }
        Server server = null;
        while (server == null){
            if (Thread.interrupted()){
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int servCount = allList.size();
            if (servCount == 0){
                return null;
            }
            //处理选择服务器的逻辑
            if (total < 5) {
                server = upList.get(currentIndex);
                ++total;
            }else {
                total = 0;
                currentIndex = currentIndex >= upList.size() - 1 ? 0 : ++currentIndex;
            }
            if (server == null){
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;
    }
}
