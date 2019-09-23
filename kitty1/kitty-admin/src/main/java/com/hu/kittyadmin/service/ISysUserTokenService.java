package com.hu.kittyadmin.service;

import com.hu.kittyadmin.entity.SysUserToken;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.kittycore.service.CurdService;

/**
 * <p>
 * 用户Token 服务类
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
public interface ISysUserTokenService extends IService<SysUserToken> {

    SysUserToken findByToken(String token);

    SysUserToken findByUserId(Long userId);

    SysUserToken createToken(Long userId);
}
