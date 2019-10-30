package com.zhhe.webshop.service;

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
}
