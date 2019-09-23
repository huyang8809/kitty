package com.hu.springbootspringsecurity.service;

import com.hu.springbootspringsecurity.entity.User;

import java.util.Set;

/**
 * @Author: hy
 * @Date: 2019/8/31
 */
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);
    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String username);
}
