package com.hu.kittyadmin.oauth2;

import com.hu.kittyadmin.entity.SysUser;
import com.hu.kittyadmin.entity.SysUserToken;
import com.hu.kittyadmin.service.ISysUserService;
import com.hu.kittyadmin.service.ISysUserTokenService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 认证Realm实现
 *
 * @Author: hy
 * @Date: 2019/8/28
 */
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ISysUserTokenService sysUserTokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /*
     * 授权(接口保护，验证接口调用权限时调用)
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        // 用户权限列表，根据用户拥有的权限标识与如 @permission标注的接口对比，决定是否可以调用接口
        Set<String> permsSet = sysUserService.findPermissions(user.getName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /*
     * 认证(登录时调用)
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        // 根据accessToken，查询用户token信息
        SysUserToken sysUserToken = sysUserTokenService.findByToken(token);
        if (sysUserToken == null || sysUserToken.getExpireTime().getTime() < System.currentTimeMillis()){
            // token已经失效
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        // 查询用户信息
        SysUser user = sysUserService.getById(sysUserToken.getUserId());
        // 账号被锁定
        if (user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,token,getName());
        return info;
    }
}
