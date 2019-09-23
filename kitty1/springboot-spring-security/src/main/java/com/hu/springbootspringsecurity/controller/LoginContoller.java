package com.hu.springbootspringsecurity.controller;

import com.hu.springbootspringsecurity.http.HttpResult;
import com.hu.springbootspringsecurity.security.JwtAuthenticatioToken;
import com.hu.springbootspringsecurity.util.SecurityUtils;
import com.hu.springbootspringsecurity.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: hy
 * @Date: 2019/8/31
 */
@RestController
public class LoginContoller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public HttpResult  login(@RequestBody LoginBean loginBean, HttpServletRequest request){
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();

        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }
}
