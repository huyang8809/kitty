package com.hu.kittycore.page;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
@Getter
@Setter
public class PageResult{
    //当前页码
    private int pageNum;
    //每页数量
    private int pageSize;
    //记录总数
    private long totalSize;
    //总页数
    private int totalPages;
    //数据模型
    private List<?> content;
}
