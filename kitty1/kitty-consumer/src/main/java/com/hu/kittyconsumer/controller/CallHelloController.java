package com.hu.kittyconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/call")
    public Object call(){
       ServiceInstance serviceInstance = loadBalancerClient.choose("kitty-producer");
        System.out.println("服务地址："+serviceInstance.getUri());
        System.out.println("服务名称："+serviceInstance.getServiceId());
        String callServiceResult  = new RestTemplate().getForObject(serviceInstance.getUri().toString()+"/hello",String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
