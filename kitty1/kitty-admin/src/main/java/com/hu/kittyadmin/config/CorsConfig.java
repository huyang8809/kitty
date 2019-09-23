package com.hu.kittyadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: hy
 * @Date: 2019/8/29
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{

    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")  //允许跨域访问路径
        .allowedOrigins("*")    //允许跨域访问的源
        .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")  //允许请求方法
        .maxAge(168000) //预检间隔时间
        .allowedHeaders("*")    //允许头部设置
        .allowCredentials(true);    //允许发送cookies

    }
}
