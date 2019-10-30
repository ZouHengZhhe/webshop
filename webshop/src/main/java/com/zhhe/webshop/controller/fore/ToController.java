package com.zhhe.webshop.controller.fore;

import com.zhhe.webshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
