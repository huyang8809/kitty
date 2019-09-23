package com.hu.springbootmongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: hy
 * @Date: 2019/9/10
 */
@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;

    private String name;

    private Integer age;
}
