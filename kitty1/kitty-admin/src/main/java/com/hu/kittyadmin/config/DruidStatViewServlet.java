package com.hu.kittyadmin.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.Serializable;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
//@WebServlet(urlPatterns = "/druid/*", initParams={
//        @WebInitParam(name="allow",value="localhost"),    // IP白名单 (没有配置或者为空，则允许所有访问)
//        @WebInitParam(name="deny",value="192.168.6.73"),    // IP黑名单 (存在共同时，deny优先于allow)
//        @WebInitParam(name="loginUsername",value="admin"),    // 用户名
//        @WebInitParam(name="loginPassword",value="admin"),    // 密码
//        @WebInitParam(name="resetEnable",value="true")    // 禁用HTML页面上的“Reset All”功能
//})
public class DruidStatViewServlet extends StatViewServlet {

}
