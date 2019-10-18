package com.zhhe.webshop.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/*
 *Author:ZouHeng
 *Des:订单表
 *Date:2019-10-18 14:35
 */
@Entity
@Data
public class OrderTable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float total;        //总价
    private Integer amount;     //商品总数
    private Integer status;     //订单状态：1未付款/2已付款/3已发货/4已完成
    private Integer paytype;    //支付方式：1微信/2支付宝/3货到付款
    private String name;        //收货人
    private String phone;       //收货电话
    private String address;     //收货地址
    private Date datetime;      //下单时间
    private Integer user_id;    //下单用户
}
