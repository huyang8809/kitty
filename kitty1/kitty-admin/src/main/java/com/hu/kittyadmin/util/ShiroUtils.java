package com.hu.kittyadmin.util;

import com.hu.kittyadmin.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Author: hy
 * @Date: 2019/8/29
 */
public class ShiroUtils {
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static SysUser getUser(){
        Object user = SecurityUtils.getSubject().getPrincipal();
        return user == null ? null : ((SysUser) user);
    }

    public static void setSessionAttribute(Object key, Object value){
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key){
        Object attribute = getSession().getAttribute(key);
        return attribute;
    }

    public static boolean isLogin(){
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }
}
