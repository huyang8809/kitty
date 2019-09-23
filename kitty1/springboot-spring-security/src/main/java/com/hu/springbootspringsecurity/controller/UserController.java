package com.hu.springbootspringsecurity.controller;

import com.hu.springbootspringsecurity.http.HttpResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hy
 * @Date: 2019/8/31
 */
@RestController
@RequestMapping("user")
public class UserController {

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping("/findAll")
    public HttpResult findAll() {
        return HttpResult.ok("the findAll service is called success.");
    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @GetMapping("/edit")
    public HttpResult edit(){
        return HttpResult.ok("the edit service is called success.");
    }

    @PreAuthorize("hasAuthority('sys:user:delete')")
    @GetMapping(value="/delete")
    public HttpResult delete(){
        return HttpResult.ok("the delete service is called success.");
    }
}
