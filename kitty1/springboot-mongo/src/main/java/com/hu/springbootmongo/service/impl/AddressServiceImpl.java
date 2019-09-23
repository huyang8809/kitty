package com.hu.springbootmongo.service.impl;

import com.hu.springbootmongo.dao.AddressRepository;
import com.hu.springbootmongo.entity.Address;
import com.hu.springbootmongo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Address address) {

    }

    @Override
    public List<Address> findAddresses(String province) {
        return addressRepository.findAddressByProvince(province);
    }
}
