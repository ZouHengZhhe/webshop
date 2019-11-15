package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.Type;
import com.zhhe.webshop.bean.model.GoodsDetail;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.repository.GoodsRepository;
import com.zhhe.webshop.repository.TypeRepository;
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
    @Autowired
    private TypeRepository typeRepository;

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

//    //分页查询商品
//    @Override
//    public List<Goods> findGoodsList(int typeId,int pageNo,int pageSize)
//    {
//        int startIndex=(pageNo-1)*pageSize;
//        if (typeId==0)
//        {
//            return goodsRepository.findAllGoodsList(startIndex, pageSize);
//        }
//        return goodsRepository.findTypeGoodsList(typeId, startIndex, pageSize);
//    }

    //返回分页相关数据模型
    @Override
    public Page getGoodsPage(int typeId, int pageNo)
    {
        Page page=new Page();
        page.setPageNumber(pageNo);
        int pageSize=8;
        page.setPageSize(pageSize);
        List list = null;
        int startIndex=(pageNo-1)*pageSize;
        if (typeId==0)
        {
            page.setTotalCount(goodsRepository.getAllGoodsCount());
            list=goodsRepository.findAllGoodsList(startIndex, pageSize);
        }
        else
        {
            page.setTotalCount(goodsRepository.getTypeGoodsCount(typeId));
            list=goodsRepository.findTypeGoodsList(typeId, startIndex, pageSize);
        }
        page.setPageSizeAndTotalCount(pageSize,page.getTotalCount());
        page.setList(list);
        return page;
    }

    @Override
    public Page getGoodsRecommendPage(int typeId, int pageNumber)
    {
        Page page=new Page();
        page.setPageNumber(pageNumber);
        int pageSize=8;
        page.setPageSize(pageSize);
        int startIndex=(pageNumber-1)*pageSize;
        page.setTotalCount(goodsRepository.getGoodsRecommendCount(typeId));
        List list=goodsRepository.findTypeGoodsList(typeId, startIndex, pageSize);
        page.setPageSizeAndTotalCount(pageSize,page.getTotalCount());
        page.setList(list);
        return page;
    }

    @Override
    public GoodsDetail findDetailById(Integer goodsId)
    {
        Goods goods=goodsRepository.findById(goodsId).get();
        Type type=typeRepository.findById(goods.getType_id()).get();
        GoodsDetail goodsDetail=new GoodsDetail(goods, type);
        return goodsDetail;
    }

    @Override
    public Goods getGoodsById(Integer id)
    {
        return goodsRepository.findById(id).get();
    }

    //搜索商品，模糊查询
    @Override
    public Page getGoodsSearchPage(String keyword,int pageNo)
    {
        Page page=new Page();
        page.setPageNumber(pageNo);
        int pageSize=8;
        page.setPageSize(pageSize);
        int startIndex=(pageNo-1)*pageSize;
        page.setTotalCount(goodsRepository.fuzzySearchCount(keyword));
        List list=goodsRepository.fuzzySearchGoods(keyword,startIndex,pageSize);
        page.setPageSizeAndTotalCount(pageSize,page.getTotalCount());
        page.setList(list);
        return page;
    }
}
