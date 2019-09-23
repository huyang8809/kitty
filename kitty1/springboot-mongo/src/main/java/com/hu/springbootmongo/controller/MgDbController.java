package com.hu.springbootmongo.controller;

import com.hu.springbootmongo.dao.AddressRepository;
import com.hu.springbootmongo.dao.UserRepository;
import com.hu.springbootmongo.entity.Address;
import com.hu.springbootmongo.entity.User;
import com.hu.springbootmongo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
@RestController
public class MgDbController {

    //仓储
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressService addressService;

    @GetMapping("/add")
    public String addAddress(){
        Address address = new Address();
        address.setId("1");
        address.setProvince("陕西");
        address.setCity("西安");
        address.setDistrict("锦业路");
        address.setStatus("0");

        addressService.addAddress(address);
        return "添加成功";
    }

    @GetMapping("/find")
    public String findAddress(){
      List<Address> list = addressService.findAddresses("陕西");
      return list.toString();

    }

    @GetMapping("addUser")
    public String addUser(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(27);
        userRepository.save(user);
        userRepository.deleteByName("huyang");
        return userRepository.findByName("zhangsan").toString();
    }



}
