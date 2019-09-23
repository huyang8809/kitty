package com.hu.kittyconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */
@FeignClient(name = "kitty-producer",fallback = KittyProducerHystrix.class)
@Component
public interface KittyProducerService {

    @GetMapping("/hello")
    public String hello();
}
