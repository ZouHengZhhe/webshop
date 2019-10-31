package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.model.Page;

import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 13:31
 */
public interface GoodsService
{
    List<Map<String,Object>> getGoodsList(int recommendType);
    Map<String,Object> getScrollGoods();
//    List<Goods> findGoodsList(int typeId,int pageNo,int pageSize);
    Page getGoodsPage(int typeId,int pageNo);
    Page getGoodsRecommendPage(int typeId,int pageNumber);

}
