package com.hu.kittyadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hu.kittyadmin.entity.SysMenu;
import com.hu.kittyadmin.mapper.SysMenuMapper;
import com.hu.kittyadmin.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.kittycore.page.PageRequest;
import com.hu.kittycore.page.PageResult;
import com.hu.kittycore.page.PageUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtil.getPageResult(getPageInfo(pageRequest));
    }

    @Override
    public List<SysMenu> selectMenuByUser(String name) {
        return baseMapper.selectMenuByUser(name);
    }

    public int delete(SysMenu record) {
        return baseMapper.deleteById(record.getId());
    }

    @Override
    public int delete(List<SysMenu> sysMenus) {
        for (SysMenu menu : sysMenus){
            delete(menu);
        }
        return 1;
    }

    @Override
    public List<SysMenu> findTree(String userName, Integer menuType) {

        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = selectMenuByUser(userName);
        for (SysMenu sysMenu : menus){
            if (sysMenu.getParentId() == null || sysMenu.getParentId() == 0){
                sysMenu.setLevel(0);
            }
            sysMenus.add(sysMenu);
        }
        sysMenus.sort((o1,o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus,menus,menuType);
        return sysMenus;
    }

    private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, Integer menuType) {
        for (SysMenu sysMenu : sysMenus){
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus){
                if (menuType == 1 && menu.getType() == 2){
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())){
                    menu.setParentName(sysMenu.getName());
                    menu.setLevel(sysMenu.getLevel()+1);
                    if (!exists(children,menu)){
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort((o1,o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children,menus,menuType);
        }
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<SysMenu> getPageInfo(PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<SysMenu> sysMenus = baseMapper.selectPage();
        return new PageInfo<>(sysMenus);
    }

    private boolean exists(List<SysMenu> sysMenus,SysMenu menu){
        boolean exists = false;
        for (SysMenu sysMenu : sysMenus){
            if (menu.getId().equals(sysMenu.getId())){
                exists = true;
            }
        }
        return exists;
    }
}
