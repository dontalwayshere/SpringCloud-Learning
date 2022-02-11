package com.matthew.practice.lb;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * openfeign + ribbon 自定义负载均衡算法
 */
public class CustomerBalancerRule implements IRule {

    private ILoadBalancer balancer = new BaseLoadBalancer();
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }

    @Override
    public Server choose(Object key) {
        List<Server> servers = balancer.getAllServers();
        int andIncrement = getAndIncrement();
        int index = andIncrement % servers.size();

        //简单权重算法
        if (andIncrement % 2 == 0 || getAndIncrement() % 3 == 0) {
            index = 0;
        }
        return servers.get(index);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.balancer = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.balancer;
    }
}