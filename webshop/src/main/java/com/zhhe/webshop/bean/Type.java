package com.zhhe.webshop.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *Author:ZouHeng
 *Des:类目表
 *Date:2019-10-18 14:29
 */
@Entity
@Data
public class Type
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
