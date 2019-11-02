package com.zhhe.webshop.bean.model;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-01 16:05
 */
@Getter
@Setter
@AllArgsConstructor
public class GoodsDetail
{
    private Goods goods;
    private Type type;
}
