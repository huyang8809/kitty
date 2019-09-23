package com.hu.kittyadmin.service;

import com.hu.kittyadmin.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.kittycore.service.CurdService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
public interface ISysUserService extends IService<SysUser> {
    List<SysUser> selectAll();

    Set<String> findPermissions(String username);

    SysUser findUserByName(String username);
}
