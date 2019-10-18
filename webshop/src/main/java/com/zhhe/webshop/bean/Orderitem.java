package com.zhhe.webshop.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *Author:ZouHeng
 *Des:订单项表
 *Date:2019-10-18 14:43
 */
@Entity
@Data
public class Orderitem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float price;        //购买时价格
    private Integer amount;     //数量
    private Integer goods_id;   //产品id
    private Integer order_id;   //订单id
}
