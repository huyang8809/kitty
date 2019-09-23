package com.hu.kittyadmin.mapper;

import com.hu.kittyadmin.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectAll();

    SysUser findByName(@Param(value="name") String name);
}
