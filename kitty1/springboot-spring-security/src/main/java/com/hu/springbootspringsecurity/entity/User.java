package com.hu.springbootspringsecurity.entity;

import lombok.Data;

/**
 * @Author: hy
 * @Date: 2019/8/31
 */
@Data
public class User {
    private Long id;

    private String username;

    private String password;
}
