package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.Recommend;
import com.zhhe.webshop.repository.RecommendRepo;
import com.zhhe.webshop.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-05  9:33
 */
@Service
public class RecommendServiceImpl implements RecommendService
{
    @Autowired
    private RecommendRepo recommendRepo;

    @Override
    public Recommend findByGoodsIdAndTypeId(Integer goodsId,Integer typeId)
    {
        return recommendRepo.findByGoodsIdAndType(goodsId, typeId);
    }

    @Override
    @Transactional
    public void save(Recommend recommend)
    {
        recommendRepo.save(recommend);
    }

    @Override
    @Transactional
    public void del(Recommend recommend)
    {
        recommendRepo.delete(recommend);
    }
}
