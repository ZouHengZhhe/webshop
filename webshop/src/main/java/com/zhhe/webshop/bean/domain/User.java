package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

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

    public void userValued(Map<String,String[]> map)
    {
        if (map.containsKey("id"))
        {
            this.id=Integer.parseInt(map.get("id")[0]);
        }
        if (map.containsKey("username"))
        {
            this.username=map.get("username")[0];
        }
        if (map.containsKey("email"))
        {
            this.email=map.get("email")[0];
        }
        if (map.containsKey("password"))
        {
            this.password=map.get("password")[0];
        }
        if (map.containsKey("name"))
        {
            this.name=map.get("name")[0];
        }
        if (map.containsKey("phone"))
        {
            this.phone=map.get("phone")[0];
        }
        if (map.containsKey("address"))
        {
            this.address=map.get("address")[0];
        }
    }
}
