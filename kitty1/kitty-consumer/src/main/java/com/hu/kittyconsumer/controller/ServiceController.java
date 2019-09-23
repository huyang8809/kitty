package com.hu.kittyconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */
@RestController
public class ServiceController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    /*
    * 获取所有服务
    * */
    @GetMapping("/services")
    public Object services(){
        return discoveryClient.getInstances("kitty-producer");
    }

    /*
    * 从所有服务中选择一个服务轮询
    * */
    @GetMapping("/discover")
    public Object discover(){
        return loadBalancerClient.choose("kitty-producer").getUri().toString();
    }
}
