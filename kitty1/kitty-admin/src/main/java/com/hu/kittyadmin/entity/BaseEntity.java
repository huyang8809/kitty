package com.hu.kittyadmin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: hy
 * @Date: 2019/8/28
 */
@Data
public class BaseEntity {

    private Long id;
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer delFlag;


}
