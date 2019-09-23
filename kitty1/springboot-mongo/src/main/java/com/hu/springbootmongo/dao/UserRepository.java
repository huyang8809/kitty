package com.hu.springbootmongo.dao;

import com.hu.springbootmongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
public interface UserRepository extends MongoRepository<User,String>{
        User findByName(String name);

        void deleteByName(String name);
}
