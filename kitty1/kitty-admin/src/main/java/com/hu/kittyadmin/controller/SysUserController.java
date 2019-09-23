package com.hu.kittyadmin.controller;


import com.hu.kittyadmin.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
@Api("用户控制器")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    ISysUserService sysUserService;


    @GetMapping("/findAll")
    public Object findAll(){
        return sysUserService.selectAll();
    }

    @ApiOperation(value = "获取用户信息",notes = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "userId",value = "用户ID",required = true,dataType = "Long")
    @GetMapping("/findUserById")
    public Object findUserById(@RequestParam Long userId){
      return   sysUserService.getById(userId);
    }

    @GetMapping("/findPermissions")
    public Object findPermissions(String username){
        return sysUserService.findPermissions(username);
    }


    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("name","hy");
        String name =  (String)map.get("name");
        System.out.println(name);
    }
}
