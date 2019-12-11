package com.zhhe.webshop.bean.domain;

import lombok.Data;

import javax.persistence.*;

/*
 *Author:ZouHeng
 *Des:商品推荐表
 *Date:2019-10-18 14:30
 */
@Entity
@Data
public class Recommend
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer type;       //推荐类型(1条幅/2热销/3新品)
    private Integer goods_id;

    public Recommend()
    {
    }

    public Recommend(Integer type, Integer goods_id)
    {
        this.type = type;
        this.goods_id = goods_id;
    }
}
