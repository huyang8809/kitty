package com.hu.kittyadmin.controller;


import com.hu.kittyadmin.entity.SysMenu;
import com.hu.kittyadmin.service.ISysMenuService;
import com.hu.kittycore.http.HttpResult;
import com.hu.kittycore.http.HttpStatus;
import com.hu.kittycore.page.PageRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {
    @Autowired
    private ISysMenuService menuService;

    @PostMapping("/findPage")
    public Object findPage(@RequestBody PageRequest request){
       return HttpResult.ok(menuService.findPage(request));
    }

    @RequiresPermissions({"sys:menu:add","sys:menu:edit"})
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysMenu record){
        return HttpResult.ok(menuService.save(record));
    }

    @RequiresPermissions({"sys:menu:delete"})
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records){
        return HttpResult.ok(menuService.delete(records));
    }

    @RequiresPermissions({"sys:menu:view"})
    @GetMapping("findNavTree")
    public HttpResult findNavTree(@RequestParam String userName){
        return HttpResult.ok(menuService.findTree(userName,1));
    }

    @RequiresPermissions("sys:menu:view")
    @GetMapping(value="/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(menuService.findTree(null, 0));
    }
}
