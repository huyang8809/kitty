package com.hu.springbootmongo.dao;

import com.hu.springbootmongo.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
public interface AddressRepository extends AddressExtRepository,MongoRepository<Address,String>{

    @Query(fields = "{'province':0}")
    List<Address> findAddressByProvince(String province);

    @Query()//fields表示包含的字段
    List<Address> findAddressByProvinceAndCityAndDistrict(String province,String city,String district);


}
