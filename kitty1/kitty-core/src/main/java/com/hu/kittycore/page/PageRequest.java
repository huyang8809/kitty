package com.hu.kittycore.page;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
@Getter
@Setter
public class PageRequest {
    //当前页码
    private int pageNum;
    //每页数量
    private int pageSize;
}
