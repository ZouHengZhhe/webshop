package com.zhhe.webshop.ctrl.admin;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhhe.webshop.bean.domain.Type;
import com.zhhe.webshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-04  9:12
 */
@Controller
@RequestMapping("admin")
public class AdminTypeCtrl
{
    @Autowired
    private TypeService typeService;

    @RequestMapping("type_list")
    public ModelAndView goodsTypeList(ModelAndView modelAndView)
    {
        List<Type> list=typeService.findAll();
        modelAndView.addObject("typeList",list);
        modelAndView.setViewName("admin/type_list");
        return modelAndView;
    }

    @PostMapping("type_add")
    public ModelAndView typeAdd(ModelAndView modelAndView,String name)
    {
        boolean isSucc=typeService.addType(name);
        if (isSucc)
        {
            modelAndView.addObject("msg","添加商品类别成功！");
        }
        else
        {
            modelAndView.addObject("failMsg","添加商品类别失败！");
        }
        modelAndView.setViewName("redirect:/admin/type_list");
        return modelAndView;
    }

    @RequestMapping("type_del")
    public ModelAndView typeDel(ModelAndView modelAndView, HttpServletRequest request)
    {
        Integer id=Integer.parseInt(request.getParameter("id"));
        boolean isSucc=typeService.delType(id);
        if (isSucc)
        {
            modelAndView.addObject("msg","删除商品类别成功！");
        }
        else
        {
            modelAndView.addObject("failMsg","删除商品类别失败！");
        }
        modelAndView.setViewName("redirect:/admin/type_list");
        return modelAndView;
    }

    @RequestMapping("type_edit")
    public ModelAndView typeEdit(ModelAndView modelAndView, HttpServletRequest request)
    {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        boolean isSucc=typeService.editType(id,name);
        if (isSucc)
        {
            modelAndView.addObject("msg","修改商品类别成功！");
        }
        else
        {
            modelAndView.addObject("failMsg","修改商品类别失败！");
        }
        modelAndView.setViewName("redirect:/admin/type_list");
        return modelAndView;
    }
}
