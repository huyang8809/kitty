package com.hu.kittyadmin.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录接口封装对象
 * @Author: hy
 * @Date: 2019/8/28
 */
@Getter
@Setter
public class LoginBean {
    private String account;

    private String password;

    private String captcha;
}
