package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.model.GoodsDetail;
import com.zhhe.webshop.bean.model.Page;
import org.springframework.web.multipart.MultipartFile;

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
    GoodsDetail findDetailById(Integer goodsId);
    Goods getGoodsById(Integer id);
    Page getGoodsSearchPage(String keyword,int pageNo);
    void addGoods(String name, MultipartFile cover, MultipartFile image1, MultipartFile image2, Float price, String intro, Integer stock, Integer type_id) throws Exception;
    Goods getGoodsWithUrl(Integer id);
    void updateGoods(Goods goods,MultipartFile cover,MultipartFile image1,MultipartFile image2) throws Exception;
    void delGoods(Integer id);
}
