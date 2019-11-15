package com.zhhe.webshop.ctrl.fore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-05  16:56
 */
@Controller
@RequestMapping("fore")
public class ToCtrl
{
    @RequestMapping("toRegister")
    public String toRegister()
    {
        return "fore/register";
    }

    @RequestMapping("toLogin")
    public String toLogin()
    {
        return "fore/login";
    }

    @RequestMapping("toCenter")
    public String toCenter()
    {
        return "fore/mycenter";
    }

    @RequestMapping("toGoodsCart")
    public String toGoodsCart()
    {
        return "fore/goods_cart";
    }

    @RequestMapping("toTest")
    public String toTest()
    {
        return "test";
    }
}
