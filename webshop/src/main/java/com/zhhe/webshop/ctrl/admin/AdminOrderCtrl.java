package com.zhhe.webshop.ctrl.admin;

import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.filter.Power;
import com.zhhe.webshop.repository.OrderRepository;
import com.zhhe.webshop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-19  13:20
 */
@Controller
@RequestMapping("admin")
@Slf4j
public class AdminOrderCtrl
{
    @Autowired
    private OrderService orderService;

    @Power
    @RequestMapping("order_list")
    public ModelAndView orderList(ModelAndView modelAndView, HttpServletRequest request)
    {
        int orderStatus = 0;
        if (request.getParameter("orderStatus") != null)
        {
            orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
        }
        int pageNo = 1;
        if (request.getParameter("pageNo") != null)
        {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page = orderService.getOrderPage(orderStatus, pageNo);
        modelAndView.addObject("page",page);
        modelAndView.addObject("orderStatus", orderStatus);
        modelAndView.setViewName("admin/order_list");

        return modelAndView;
    }

    @Power
    @RequestMapping("order_status")
    public ModelAndView orderStatus(ModelAndView modelAndView,HttpServletRequest request)
    {
        int id= Integer.parseInt(request.getParameter("id"));
        int status =Integer.parseInt(request.getParameter("orderStatus"));
        orderService.updateStatus(id,status);
        modelAndView.setViewName("redirect:/admin/order_list?orderStatus="+status);
        return modelAndView;
    }

    @Power
    @RequestMapping("order_del")
    public ModelAndView orderDel(ModelAndView modelAndView,HttpServletRequest request)
    {
        int id= Integer.parseInt(request.getParameter("id"));
        int status =Integer.parseInt(request.getParameter("orderStatus"));
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));
        orderService.delOrder(id);
        modelAndView.setViewName("redirect:/admin/order_list?orderStatus="+status+"&pageNo="+pageNo);
        return modelAndView;
    }
}