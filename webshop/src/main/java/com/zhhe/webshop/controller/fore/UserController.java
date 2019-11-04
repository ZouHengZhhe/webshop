package com.zhhe.webshop.controller.fore;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhhe.webshop.bean.domain.User;
import com.zhhe.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("fore")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("toRegister")
    public ModelAndView toRegister(ModelAndView modelAndView)
    {
        modelAndView.setViewName("fore/register");
        return modelAndView;
    }

    @PostMapping("register")
    public ModelAndView register(ModelAndView modelAndView, User user)
    {
        if (userService.addUser(user))
        {
            modelAndView.addObject("msg","注册成功，请登录！");
            modelAndView.setViewName("fore/login");
        }
        else
        {
            modelAndView.addObject("msg","注册失败，账户名或邮箱重复，请重新填写！");
            modelAndView.setViewName("fore/register");
        }
        return modelAndView;
    }

    @RequestMapping("toLogin")
    public ModelAndView toLogin(ModelAndView modelAndView)
    {
        modelAndView.setViewName("fore/login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request)
    {
        String ue=request.getParameter("ue");
        String password=request.getParameter("password");
        User user=userService.login(ue,password);
        if (user == null)
        {
            modelAndView.addObject("failMsg","账户名/邮箱或密码错误，请重新登陆!");
            modelAndView.setViewName("fore/login");
        }
        else
        {
            modelAndView.addObject("user",user);
            modelAndView.setViewName("fore/mycenter");
        }
        return modelAndView;
    }
}
