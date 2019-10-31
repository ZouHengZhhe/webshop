package com.zhhe.webshop.controller.fore;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.service.GoodsService;
import com.zhhe.webshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 10:50
 */
@Controller
@RequestMapping("fore")
public class ToController
{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView)
    {
        //取得条幅商品
        Map<String,Object> scrollGoodsMap=goodsService.getScrollGoods();
        //取得热销商品
        List<Map<String,Object>> hotGoodsList = goodsService.getGoodsList(2);
        //取得新品商品
        List<Map<String,Object>> newGoodsList = goodsService.getGoodsList(3);
        modelAndView.addObject("hotGoodsList",hotGoodsList);
        modelAndView.addObject("newGoodsList",newGoodsList);
        modelAndView.addObject("scrollGoodsMap",scrollGoodsMap);
        modelAndView.setViewName("fore/index");
        return modelAndView;
//        return "fore/index";
    }

    @RequestMapping("goodsList")
    public ModelAndView goodsList(ModelAndView modelAndView, ServletRequest request)
    {
//        System.out.println("id = "+request.getParameter("id"));
        int typeId=0;
        String typeName="全部系列";
        if (request.getParameter("id")!=null)
        {
            typeId=Integer.parseInt(request.getParameter("id"));
            typeName=typeService.getTypeNameById(typeId);
        }
        int pageNo=1;
        if (request.getParameter("pageNo")!=null)
        {
            pageNo=Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page = goodsService.getGoodsPage(typeId, pageNo);
        modelAndView.addObject("page",page);
        modelAndView.addObject("id",typeId);
        modelAndView.addObject("typeName",typeName);
        modelAndView.setViewName("fore/goodslist");
        return modelAndView;
    }

    @RequestMapping("goodsRecommendList")
    public ModelAndView goodsRecommendList(ModelAndView modelAndView, ServletRequest request)
    {
        int typeId=Integer.parseInt(request.getParameter("typeId"));
        int pageNumber=1;
        if (typeId==2)
        {
            modelAndView.addObject("name","热销商品");
        }
        else
        {
            modelAndView.addObject("name","新品商品");
        }
        if (request.getParameter("pageNumber")!=null)
        {
            pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page page=goodsService.getGoodsRecommendPage(typeId, pageNumber);
        modelAndView.addObject("page",page);
        modelAndView.addObject("typeId",typeId);
        modelAndView.setViewName("fore/goodsRecommendList");
        return modelAndView;
    }
}
