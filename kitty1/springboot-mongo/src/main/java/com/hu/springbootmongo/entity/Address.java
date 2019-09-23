package com.hu.springbootmongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
@Data
public class Address {

    @Id
    private String id;

    private String province;

    private String city;

    private String district;

    private String status;
}
