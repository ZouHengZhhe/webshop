package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.Type;
import com.zhhe.webshop.bean.model.GoodsDetail;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.repository.GoodsRepository;
import com.zhhe.webshop.repository.TypeRepository;
import com.zhhe.webshop.service.GoodsService;
import com.zhhe.webshop.util.MinioUtil;
import com.zhhe.webshop.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private MinioUtil minioUtil;

    @Override
    public List<Map<String, Object>> getGoodsList(int recommendType)
    {
        //todo:获取图片url出错
        List<Map<String, Object>> list=goodsRepository.getGoodsList(recommendType);
        List<Map<String,Object>> myList=new ArrayList<>();
        for (Map<String,Object> m:list)
        {
            Integer id= (Integer) m.get("id");
            String coverUrl=minioUtil.getImgUrl(goodsRepository.getCoverName(id));
            Map<String,Object> myMap=new HashMap<>();
            for (String key : m.keySet())
            {
                myMap.put(key,m.get(key));
            }
            myMap.put("coverUrl",coverUrl);

        }

        return list;
    }

    @Override
    public Map<String, Object> getScrollGoods()
    {
        Map<String,Object> map=goodsRepository.getScrollGoods();
        Integer id= (Integer) map.get("id");
        String coverUrl=minioUtil.getImgUrl(goodsRepository.getCoverName(id));
        Map<String,Object> myMap=new HashMap<>();
        for (String key : map.keySet())
        {
            myMap.put(key,map.get(key));
        }
        myMap.put("coverUrl",coverUrl);
        return myMap;
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
        setTypeNameAndImgUrl(list);
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
        List list=goodsRepository.getGoodsRecommendList(typeId, startIndex, pageSize);
        page.setPageSizeAndTotalCount(pageSize,page.getTotalCount());
        setTypeNameAndImgUrl(list);
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

    @Override
    @Transactional
    public void addGoods(String name, MultipartFile cover, MultipartFile image1, MultipartFile image2, Float price, String intro, Integer stock, Integer type_id) throws Exception
    {
        String coverName= Util.getName(cover);
        String image1Name=Util.getName(image1);
        String image2Name=Util.getName(image2);

        Goods goods=new Goods(name,coverName,image1Name,image2Name,price,intro,stock,type_id);
        goodsRepository.save(goods);

        //上传图片
        minioUtil.uploadImg(cover,coverName);
        minioUtil.uploadImg(image1,image1Name);
        minioUtil.uploadImg(image2,image2Name);
    }

    /**
     * 根据id获取Goods，同时获取Goods图片的URL
     */
    @Override
    public Goods getGoodsWithUrl(Integer id)
    {
        Goods goods=goodsRepository.findById(id).get();
        goods.setCoverUrl(minioUtil.getImgUrl(goods.getCover()));
        goods.setImg1Url(minioUtil.getImgUrl(goods.getImage1()));
        goods.setImg2Url(minioUtil.getImgUrl(goods.getImage2()));
        return goods;
    }

    //修改商品
    @Override
    public void updateGoods(Goods goods, MultipartFile cover, MultipartFile image1, MultipartFile image2) throws Exception
    {
        Goods oldGoods=goodsRepository.findById(goods.getId()).get();
        String coverName,image1Name,image2Name;
        coverName=cover.isEmpty()?oldGoods.getCover():Util.getName(cover);
        image1Name=image1.isEmpty()?oldGoods.getImage1():Util.getName(image1);
        image2Name=image2.isEmpty()?oldGoods.getImage2():Util.getName(image2);
        goods.setCover(coverName);
        goods.setImage1(image1Name);
        goods.setImage2(image2Name);
        goodsRepository.save(goods);

        if (cover!=null)
        {
            minioUtil.uploadImg(cover,coverName);
        }
        if (image1!=null)
        {
            minioUtil.uploadImg(image1,image1Name);
        }
        if (image2!=null)
        {
            minioUtil.uploadImg(image2,image2Name);
        }
    }

    @Override
    @Transactional
    public void delGoods(Integer id)
    {
        String coverName=goodsRepository.getCoverName(id);
        String img1Name=goodsRepository.getImg1Name(id);
        String img2Name=goodsRepository.getImg2Name(id);
        goodsRepository.deleteById(id);

        //删除minio上的图片
        minioUtil.delImg(coverName);
        minioUtil.delImg(img1Name);
        minioUtil.delImg(img2Name);
    }

    /**
     * 为list中的Goods设置typeName，获取图片URL
     */
    private void setTypeNameAndImgUrl(List list)
    {
        for (int i=0;i<list.size();i++)
        {
            Goods goods=(Goods)list.get(i);
            String typeName=typeRepository.findById(goods.getType_id()).get().getName();
            goods.setTypeName(typeName);
            goods.setCoverUrl(minioUtil.getImgUrl(goods.getCover()));
            goods.setImg1Url(minioUtil.getImgUrl(goods.getImage1()));
            goods.setImg2Url(minioUtil.getImgUrl(goods.getImage2()));
        }
    }
}
