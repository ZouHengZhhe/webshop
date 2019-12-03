package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.*;

/*
 *Author:ZouHeng
 *Des:订单项表
 *Date:2019-10-18 14:43
 */
@Entity
@Data
@Table(name = "order_item")
public class OrderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float price;        //购买时价格
    private Integer amount;     //数量
    private Integer goods_id;   //产品id
    private Integer order_id;   //订单id

    @Transient
    private Goods goods;    //添加Goods，方便前端获取
    @Transient
    private String goodsName;

    public OrderItem()
    {
    }
    public OrderItem(Integer id,Float price, Integer amount, Integer goods_id, Integer order_id,String goodsName)
    {
        this.id=id;
        this.price = price;
        this.amount = amount;
        this.goods_id = goods_id;
        this.order_id = order_id;
        this.goodsName=goodsName;
    }

    public OrderItem(Float price, Integer amount, Integer goods_id, Integer order_id,Goods goods)
    {
        this.price = price;
        this.amount = amount;
        this.goods_id = goods_id;
        this.order_id = order_id;
        this.goods=goods;
    }
}
