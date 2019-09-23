package com.hu.kittyadmin.service;

import com.hu.kittyadmin.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hu.kittycore.http.HttpResult;
import com.hu.kittycore.page.PageRequest;
import com.hu.kittycore.page.PageResult;
import com.hu.kittycore.service.CurdService;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);


    List<SysMenu> selectMenuByUser(String name);

    int delete(List<SysMenu> sysMenus);

    List<SysMenu> findTree(String userName,Integer menuType);

}
