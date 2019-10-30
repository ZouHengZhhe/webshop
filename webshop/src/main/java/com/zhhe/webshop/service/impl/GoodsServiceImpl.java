package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.repository.GoodsRepository;
import com.zhhe.webshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 13:31
 */
@Service
public class GoodsServiceImpl implements GoodsService
{
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Map<String, Object>> getGoodsList(int recommendType)
    {
        return goodsRepository.getGoodsList(recommendType);
    }

    @Override
    public Map<String, Object> getScrollGoods()
    {
        return goodsRepository.getScrollGoods();
    }
}
