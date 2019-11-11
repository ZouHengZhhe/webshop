package com.zhhe.webshop.bean.domain;

import com.zhhe.webshop.util.PriceUtil;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

/*
 *Author:ZouHeng
 *Des:订单表
 *Date:2019-10-18 14:35
 */
@Entity
@Data
@Table(name = "order_table")
@ToString
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

    @Transient
    private Map<String, OrderItem> itemMap=new HashMap<>();
    @Transient
    private List<OrderItem> itemList=new ArrayList<>();

    public OrderTable()
    {
    }

    public OrderTable(Float total, Integer amount)
    {
        this.total = total;
        this.amount = amount;
    }

    //将商品添加到购物车，购买商品
    public void addGoods(Goods goods)
    {
        if (itemMap.containsKey(goods.getId().toString()))
        {
            OrderItem item=itemMap.get(goods.getId().toString());
            item.setAmount(item.getAmount()+1);
        }
        else
        {
            OrderItem item=new OrderItem(goods.getPrice(),1,goods.getId(),id,goods);
            itemMap.put(goods.getId().toString(),item);
        }
        total= PriceUtil.add(total,goods.getPrice());
        amount++;
    }

    //在购物车中减少商品
    public void lessonGoods(Integer goodsId)
    {
        if (itemMap.containsKey(goodsId.toString()))
        {
            OrderItem item=itemMap.get(goodsId.toString());
            item.setAmount(item.getAmount()-1);
            amount--;
            total=PriceUtil.subtract(total,item.getPrice());
            if (item.getAmount()==0)
            {
                itemMap.remove(goodsId.toString());
            }
        }
    }

    //在购物车中删除商品
    public void delGoods(Integer goodsId)
    {
        if (itemMap.containsKey(goodsId.toString()))
        {
            OrderItem item=itemMap.get(goodsId.toString());
            amount-=item.getAmount();
            total=PriceUtil.subtract(total,item.getPrice()*item.getAmount());
            itemMap.remove(goodsId.toString());
        }
    }

}
