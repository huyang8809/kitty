package com.hu.kittyadmin.mapper;

import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.hu.kittyadmin.entity.SysUserToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户Token Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {
    SysUserToken findByToken(@Param("token") String token);

    SysUserToken findByUserId(@Param("userId") Long userId);

    @Override
    int insert(@Param("SysUserToken") SysUserToken entity);

    int updateById(@Param("sysUserToken") SysUserToken entity);
}
