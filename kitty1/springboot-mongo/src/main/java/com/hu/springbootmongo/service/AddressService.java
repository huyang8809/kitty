package com.hu.springbootmongo.service;

import com.hu.springbootmongo.entity.Address;

import java.util.List;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
public interface AddressService {

    void addAddress(Address address);

    void updateAddress(Address address);

    List<Address> findAddresses(String province);
}
