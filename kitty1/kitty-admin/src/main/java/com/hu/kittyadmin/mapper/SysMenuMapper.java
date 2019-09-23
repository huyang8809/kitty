package com.hu.kittyadmin.mapper;

import com.hu.kittyadmin.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /*
    分页查询
     */
    List<SysMenu> selectPage();

    List<SysMenu> selectMenuByUser(@Param("username") String username);



}
