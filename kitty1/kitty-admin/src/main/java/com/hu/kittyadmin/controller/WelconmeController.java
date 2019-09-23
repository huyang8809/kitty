package com.hu.kittyadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: hy
 * @Date: 2019/8/29
 */
//@Controller
public class WelconmeController {

//    @GetMapping("/")
    public String index(){
        return "redirect:login.html";
    }
}
