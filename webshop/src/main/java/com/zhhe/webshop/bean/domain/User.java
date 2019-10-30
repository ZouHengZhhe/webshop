package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-18 14:45
 */
@Entity
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private Boolean isadmin;        //是否是管理员
    private Boolean isvalidate;     //邮箱是否验证
}
