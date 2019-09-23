package com.hu.springbootspringsecurity.http;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
@Getter
@Setter
public class HttpResult {
    private int code;
    private String msg;
    private Object data;

    public static HttpResult error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static HttpResult error(int code,String msg){
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setData(data);
        return r;
    }
    public static HttpResult ok() {
        return new HttpResult();
    }
}
