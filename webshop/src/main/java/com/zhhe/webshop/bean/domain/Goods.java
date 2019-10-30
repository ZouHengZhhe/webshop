package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *Author:ZouHeng
 *Des:商品表
 *Date:2019-10-18 14:26
 */
@Entity
@Data
public class Goods
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;    //名称
    private String cover;   //封面地址
    private String image1;  //详情图片1
    private String image2;  //详情图片2
    private Float price;
    private String intro;   //简介
    private Integer stock;  //库存
    private Integer type_id;
}
