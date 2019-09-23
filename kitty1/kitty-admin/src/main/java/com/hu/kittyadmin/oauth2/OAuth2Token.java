package com.hu.kittyadmin.oauth2;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
@AllArgsConstructor
public class OAuth2Token implements AuthenticationToken {

    private String token;


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
