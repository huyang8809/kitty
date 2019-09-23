package com.hu.kittyadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hu.kittyadmin.entity.SysMenu;
import com.hu.kittyadmin.entity.SysUser;
import com.hu.kittyadmin.mapper.SysUserMapper;
import com.hu.kittyadmin.service.ISysMenuService;
import com.hu.kittyadmin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.kittycore.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    ISysMenuService sysMenuService;


    @Override
    public List<SysUser> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.selectMenuByUser(username);
        for (SysMenu menu : sysMenus){
            if (menu.getPerms() != null && !"".equals(menu.getPerms())){
                perms.add(menu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public SysUser findUserByName(String username) {
        return baseMapper.findByName(username);
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest 4bbd0cb879e1568f09b20234e565a504
     * @return
     */
    private PageInfo<SysUser> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> sysUsers = baseMapper.selectAll();
        return new PageInfo<SysUser>(sysUsers);
    }
}
