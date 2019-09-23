package com.hu.kittyconsumer.controller;

import com.hu.kittyconsumer.feign.KittyProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */
@RestController
public class FeignHelloController {
    @Autowired
    KittyProducerService kittyProducerService;

    @GetMapping("/feign/call")
    public String call(){
      return  kittyProducerService.hello();
    }
}
