package com.zhhe.webshop.ctrl.fore;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.OrderTable;
import com.zhhe.webshop.bean.model.GoodsDetail;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.service.GoodsService;
import com.zhhe.webshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 10:50
 */
@Controller
@RequestMapping("fore")
public class GoodsCtrl
{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView)
    {
        //取得条幅商品
        Map<String, Object> scrollGoodsMap = goodsService.getScrollGoods();
        //取得热销商品
        List<Map<String, Object>> hotGoodsList = goodsService.getGoodsList(2);
        //取得新品商品
        List<Map<String, Object>> newGoodsList = goodsService.getGoodsList(3);
        modelAndView.addObject("hotGoodsList", hotGoodsList);
        modelAndView.addObject("newGoodsList", newGoodsList);
        modelAndView.addObject("scrollGoodsMap", scrollGoodsMap);
        modelAndView.setViewName("fore/index");
        return modelAndView;
//        return "fore/index";
    }

    @RequestMapping("goodsList")
    public ModelAndView goodsList(ModelAndView modelAndView, ServletRequest request)
    {
        int typeId = 0;
        String typeName = "全部系列";
//        System.out.println(request.getParameter("id"));
//        System.out.println();
        if (request.getParameter("id") != null&&!request.getParameter("id").equals("0"))
        {
            typeId = Integer.parseInt(request.getParameter("id"));
            typeName = typeService.getTypeNameById(typeId);
        }
        int pageNo = 1;
        if (request.getParameter("pageNo") != null)
        {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
//        System.out.println("GoodsCtrl/goodsList   typeId = "+typeId+"   typeName = "+typeName);
        Page page = goodsService.getGoodsPage(typeId, pageNo);
        modelAndView.addObject("page", page);
        modelAndView.addObject("id", typeId);
        modelAndView.addObject("typeName", typeName);
        modelAndView.setViewName("fore/goodslist");
        return modelAndView;
    }

    @RequestMapping("goodsRecommendList")
    public ModelAndView goodsRecommendList(ModelAndView modelAndView, HttpServletRequest request)
    {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int pageNumber = 1;
        if (typeId == 2)
        {
            modelAndView.addObject("name", "热销商品");
        }
        else
        {
            modelAndView.addObject("name", "新品商品");
        }
        if (request.getParameter("pageNo") != null)
        {
            pageNumber = Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page = goodsService.getGoodsRecommendPage(typeId, pageNumber);
        modelAndView.addObject("page", page);
        modelAndView.addObject("typeId", typeId);
        modelAndView.setViewName("fore/goodsRecommendList");
        return modelAndView;
    }

    @RequestMapping("goodsDetail")
    public ModelAndView goodsDetail(ModelAndView modelAndView, ServletRequest request)
    {
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        GoodsDetail goodsDetail = goodsService.findDetailById(goodsId);
        modelAndView.addObject("goodsDetail", goodsDetail);

        modelAndView.setViewName("fore/goodsDetail");
        return modelAndView;
    }

    @PostMapping("goodsBuy")
    public void goodsBuy(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //判断是否已经有订单
        OrderTable order;
        if (request.getSession().getAttribute("order") != null)
        {
            order = (OrderTable) request.getSession().getAttribute("order");
        }
        else
        {
            order = new OrderTable(0f, 0);
        }

        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
//        System.out.println("[GoodsCtrl/goodsBuy]  goodsId = "+goodsId);
        Goods goods = goodsService.getGoodsById(goodsId);
        if (goods.getStock() > 0)
        {
            order.addGoods(goods);
            response.getWriter().print("ok");
        }
        else
        {
            response.getWriter().print("fail");
        }
        request.getSession().setAttribute("order", order);   //将订单存入session
    }

    @RequestMapping("goodsLesson")
    public void goodsLesson(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //判断是否已经有订单
        OrderTable order = (OrderTable) request.getSession().getAttribute("order");
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        order.lessonGoods(goodsId);
        response.getWriter().print("ok");
        request.getSession().setAttribute("order", order);   //将订单存入session
    }

    @RequestMapping("goodsDel")
    public void goodsDel(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        OrderTable order = (OrderTable) request.getSession().getAttribute("order");
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        order.delGoods(goodsId);
        response.getWriter().print("ok");
        request.getSession().setAttribute("order", order);   //将订单存入session
    }

    @RequestMapping("goodsSearch")
    public ModelAndView goodsSearch(ModelAndView modelAndView,HttpServletRequest request) throws UnsupportedEncodingException
    {
        String keyword=request.getParameter("keyword");
//        System.out.println("pageNo = "+request.getParameter("pageNo"));
        int pageNo = 1;
        if (request.getParameter("pageNo") != null)
        {

            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page=goodsService.getGoodsSearchPage(keyword,pageNo);
        modelAndView.addObject("page", page);
        modelAndView.addObject("keyword",keyword);
//        modelAndView.addObject("keyword", URLEncoder.encode(keyword, "utf-8"));
        modelAndView.setViewName("fore/goods_search");
        return modelAndView;
    }
}

