package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.*;

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

    @Transient
    private String typeName;
    @Transient
    private String coverUrl;
    @Transient
    private String img1Url;
    @Transient
    private String img2Url;

    public Goods()
    {
    }

    public Goods(String name, String cover, String image1, String image2, Float price, String intro, Integer stock, Integer type_id)
    {
        this.name = name;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.price = price;
        this.intro = intro;
        this.stock = stock;
        this.type_id = type_id;
    }
}
