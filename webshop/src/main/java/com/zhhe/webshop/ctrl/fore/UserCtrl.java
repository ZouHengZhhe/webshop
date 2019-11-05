package com.zhhe.webshop.ctrl.fore;

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
public class UserCtrl
{
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ModelAndView register(ModelAndView modelAndView, User user)
    {
        if (userService.addUser(user))
        {
            modelAndView.addObject("msg", "注册成功，请登录！");
            modelAndView.setViewName("fore/login");
        } else
        {
            modelAndView.addObject("msg", "注册失败，账户名或邮箱重复，请重新填写！");
            modelAndView.setViewName("fore/register");
        }
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request)
    {
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");
        User user = userService.login(ue, password);
        if (user == null)
        {
            modelAndView.addObject("failMsg", "账户名/邮箱或密码错误，请重新登陆!");
            modelAndView.setViewName("fore/login");
        } else
        {
            request.getSession().setAttribute("user", user);
//            modelAndView.addObject("user",user);
            modelAndView.setViewName("fore/mycenter");
        }
        return modelAndView;
    }

    @PostMapping("changeAddress")
    public ModelAndView changeAddress(ModelAndView modelAndView, HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        userService.update(user);
        modelAndView.addObject("msg", "收货信息修改成功！");
        modelAndView.setViewName("fore/mycenter");
        return modelAndView;
    }

    @PostMapping("changePwd")
    public ModelAndView changePwd(ModelAndView modelAndView, HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        String pwd = request.getParameter("password");
        String pwdNew = request.getParameter("passwordNew");
        if (pwd.equals(user.getPassword()))
        {
            user.setPassword(pwdNew);
            userService.update(user);
            modelAndView.addObject("msg", "密码修改成功！");
        } else
        {
            modelAndView.addObject("failMsg", "原密码错误，请重新填写相关信息！");
        }

        modelAndView.setViewName("fore/mycenter");
        return modelAndView;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().invalidate();  //清空session里面的user信息
        return "redirect:index";
    }

}
