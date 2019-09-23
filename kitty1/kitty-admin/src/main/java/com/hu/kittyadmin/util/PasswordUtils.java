package com.hu.kittyadmin.util;

import org.apache.shiro.crypto.hash.Sha256Hash;


import java.util.UUID;

/**
 * @Author: hy
 * @Date: 2019/8/29
 */
public class PasswordUtils {
    /**
     *
     * 匹配密码
     * @param salt
     * @param rawPass
     * @param encPass
     * @return
     */
    public static boolean match(String password, String salt, String encryptePassword){
        if(password != null && encrypte(password, salt).equals(encryptePassword)) {
            return true;
        }
        return false;
    }

    /**
     * 明文密码加密
     * @param password
     * @param salt
     * @return
     */
    public static String encrypte(String password, String salt) {
        return new Sha256Hash(password, salt).toHex();
    }

   /* *//**
     * 明文密码加密
     * @param rawPass
     * @param salt
     * @return
     *//*
    public static String encode(String rawPass, String salt) {
        return new BCryptPasswordEncoder().encode(rawPass);
    }*/

    /**
     * 获取加密盐
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }

    public static void main(String[] args) {

        System.out.println(PasswordUtils.encrypte("admin","YzcmCZNvbXocrsz9dm8e"));
    }
}
