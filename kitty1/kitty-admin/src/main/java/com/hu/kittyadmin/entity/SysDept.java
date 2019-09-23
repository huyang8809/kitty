package com.hu.kittyadmin.entity;

import java.time.LocalDateTime;
import com.hu.kittyadmin.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级机构ID，一级机构为0
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer orderNum;



}
