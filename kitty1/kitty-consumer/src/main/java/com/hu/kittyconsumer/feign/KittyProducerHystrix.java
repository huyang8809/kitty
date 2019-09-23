package com.hu.kittyconsumer.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */

@Component
public class KittyProducerHystrix implements KittyProducerService{
    @GetMapping("/hello")
    @Override
    public String hello() {
        return "sorry, hello service call failed.";
    }
}
