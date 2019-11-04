package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.*;

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
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    private String name;
    private String phone;
    private String address;
    private Boolean isadmin;        //是否是管理员
    private Boolean isvalidate;     //邮箱是否验证
}
