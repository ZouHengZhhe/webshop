package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.Recommend;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-05  9:33
 */
public interface RecommendService
{
    Recommend findByGoodsIdAndTypeId(Integer goodsId,Integer typeId);
    void save(Recommend recommend);
    void del(Recommend recommend);
}
