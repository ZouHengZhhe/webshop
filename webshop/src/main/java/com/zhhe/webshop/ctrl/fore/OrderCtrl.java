package com.zhhe.webshop.ctrl.fore;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zhhe.webshop.bean.domain.OrderTable;
import com.zhhe.webshop.bean.domain.User;
import com.zhhe.webshop.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-08  16:47
 */
@Controller
@RequestMapping("fore")
public class OrderCtrl
{
    @Autowired
    private OrderService orderService;

    //提交订单
    @RequestMapping("orderSubmit")
    public ModelAndView orderSubmit(ModelAndView modelAndView,HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user")!=null)
        {
            modelAndView.setViewName("fore/order_submit");
            return modelAndView;
        }
        else
        {
            modelAndView.addObject("failMsg","请先登录，再提交订单！");
            modelAndView.setViewName("fore/login");
            return modelAndView;
        }
    }

//    确认订单
    @PostMapping("orderConfirm")
    public ModelAndView orderConfirm(ModelAndView modelAndView,HttpServletRequest request)
    {
        OrderTable o= (OrderTable) request.getSession().getAttribute("order");
        o.setPaytype(Integer.parseInt(request.getParameter("payType")));
        o.setName(request.getParameter("name"));
        o.setPhone(request.getParameter("phone"));
        o.setAddress(request.getParameter("address"));
        o.setDatetime(new Date());
        o.setStatus(2); //网站目前不做支付功能，确认订单相当于直接付款
        User user= (User) request.getSession().getAttribute("user");
        o.setUser_id(user.getId());
//        System.out.println(o);
        orderService.addOrder(o);
        for (String key:o.getItemMap().keySet())
        {
            o.getItemMap().get(key).setOrder_id(o.getId());
            orderService.addOrderItem(o.getItemMap().get(key));
        }
        request.getSession().removeAttribute("order");
        request.setAttribute("msg","订单支付成功！");

        modelAndView.setViewName("fore/order_success");
        return modelAndView;
    }

    @RequestMapping("orderCenter")
    public ModelAndView orderCenter(ModelAndView modelAndView,HttpServletRequest request)
    {
        User user=(User) request.getSession().getAttribute("user");
        List<OrderTable> list=orderService.findAllByUserId(user.getId());
        modelAndView.addObject("orderList",list);
        modelAndView.setViewName("fore/order_Center");
        return modelAndView;
    }
}
