package com.hu.kittycore.page;

import com.github.pagehelper.PageInfo;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
public class PageUtil {

    public static PageResult getPageResult(PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
