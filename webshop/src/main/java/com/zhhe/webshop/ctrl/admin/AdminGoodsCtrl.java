package com.zhhe.webshop.ctrl.admin;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.Recommend;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.service.GoodsService;
import com.zhhe.webshop.service.RecommendService;
import com.zhhe.webshop.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-04  10:28
 */
@Controller
@RequestMapping("admin")
public class AdminGoodsCtrl
{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RecommendService recommendService;

    @RequestMapping("goods_list")
    public ModelAndView goodsList(ModelAndView modelAndView, HttpServletRequest request)
    {
        //typeId  0：全部商品，1：条幅商品，2：热销，3：新品
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int pageNo = 1;
        if (request.getParameter("pageNo") != null)
        {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page;
        if (typeId == 0)
        {
            page = goodsService.getGoodsPage(typeId, pageNo);
        }
        else
        {
            page = goodsService.getGoodsRecommendPage(typeId, pageNo);
        }
        modelAndView.addObject("page", page);
        modelAndView.addObject("typeId", typeId);
        modelAndView.setViewName("admin/goods_list");
        return modelAndView;
    }

    @PostMapping("goods_add")
    public ModelAndView goodsAdd(ModelAndView modelAndView, String name, String price, String intro, String stock, MultipartFile cover, MultipartFile image1, MultipartFile image2, String typeId) throws Exception
    {
        //todo:图片上传后，再商品列表中显示商品图片有问题，待修改
        Float priceT=Float.valueOf(price);
        Integer stockT=Integer.parseInt(stock);
        Integer typeIdT=Integer.parseInt(typeId);
        goodsService.addGoods(name,cover,image1,image2,priceT,intro,stockT,typeIdT);

        modelAndView.addObject("msg", "成功添加商品！");
        modelAndView.addObject("typeId", 0);
        modelAndView.setViewName("redirect:/admin/goods_list");
        return modelAndView;
    }

    //加入条幅、热销、新品
    @RequestMapping("goods_join")
    public ModelAndView goodsJoin(ModelAndView modelAndView, HttpServletRequest request)
    {
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        Recommend recommend = recommendService.findByGoodsIdAndTypeId(goodsId, typeId);
        if (recommend == null)
        {
            Recommend r = new Recommend(typeId, goodsId);
            recommendService.save(r);
        }

        String msg = null;
        switch (typeId)
        {
            case 1:
                msg = "商品加入条幅成功！";
                break;
            case 2:
                msg = "商品加入热销成功！";
                break;
            case 3:
                msg = "商品加入新品成功！";
                break;
        }
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("typeId", typeId);
        modelAndView.setViewName("redirect:/admin/goods_list");
        return modelAndView;
    }

    //移出条幅、热销、新品
    @RequestMapping("goods_remove")
    public ModelAndView goodsRemove(ModelAndView modelAndView, HttpServletRequest request)
    {
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        Recommend recommend = recommendService.findByGoodsIdAndTypeId(goodsId, typeId);
        recommendService.del(recommend);

        String msg = null;
        switch (typeId)
        {
            case 1:
                msg = "商品移出条幅成功！";
                break;
            case 2:
                msg = "商品移出热销成功！";
                break;
            case 3:
                msg = "商品移出新品成功！";
                break;
        }
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("typeId", typeId);
        modelAndView.setViewName("redirect:/admin/goods_list");
        return modelAndView;
    }

    @PostMapping("goods_edit")
    public ModelAndView goodsEdit(ModelAndView modelAndView,String id,String name, String price, String intro, String stock, MultipartFile cover, MultipartFile image1, MultipartFile image2, String typeId) throws Exception
    {
        Goods goods=new Goods();
        goods.setId(Integer.parseInt(id));
        goods.setName(name);
        goods.setPrice(Float.valueOf(price));
        goods.setIntro(intro);
        goods.setStock(Integer.parseInt(stock));
        goods.setType_id(Integer.parseInt(typeId));
        goodsService.updateGoods(goods,cover,image1,image2);

        modelAndView.addObject("msg", "成功修改商品信息！");
        modelAndView.addObject("typeId", 0);
        modelAndView.setViewName("redirect:/admin/goods_list");
        return modelAndView;
    }

    @RequestMapping("goods_del")
    public ModelAndView goodsDel(ModelAndView modelAndView, HttpServletRequest request)
    {
        Integer id =Integer.parseInt(request.getParameter("id"));
        goodsService.delGoods(id);

        modelAndView.addObject("msg", "成功删除商品！");
        modelAndView.addObject("typeId", 0);
        modelAndView.setViewName("redirect:/admin/goods_list");
        return modelAndView;
    }
}
