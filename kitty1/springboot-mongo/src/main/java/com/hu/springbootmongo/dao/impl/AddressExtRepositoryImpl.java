package com.hu.springbootmongo.dao.impl;

import com.hu.springbootmongo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
public class AddressExtRepositoryImpl implements com.hu.springbootmongo.dao.AddressExtRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Address findByProvinceAndCity(String province, String city) {
        Query query = new Query(Criteria.where("province").is(province).is(city));
        return mongoTemplate.findOne(query,Address.class,"address");
    }
}
