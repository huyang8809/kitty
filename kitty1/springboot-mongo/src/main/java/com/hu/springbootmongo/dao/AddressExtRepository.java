package com.hu.springbootmongo.dao;

import com.hu.springbootmongo.entity.Address;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
public interface AddressExtRepository {
    Address findByProvinceAndCity(String province,String city);
}
