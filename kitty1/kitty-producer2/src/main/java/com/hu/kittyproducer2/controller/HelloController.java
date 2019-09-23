package com.hu.kittyproducer2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello kitty2";
    }
}
