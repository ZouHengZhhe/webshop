package com.zhhe.webshop.ctrl.admin;

import com.zhhe.webshop.bean.domain.User;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-22  13:21
 */
@Controller
@RequestMapping("admin")
public class AdminUserCtrl
{
    @Autowired
    private UserService userService;

    @RequestMapping("user_list")
    public ModelAndView userList(ModelAndView modelAndView, HttpServletRequest request)
    {
        int pageNo = 1;
        if (request.getParameter("pageNo") != null)
        {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        Page page=userService.getUserPage(pageNo);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("admin/user_list");
        return modelAndView;
    }

    @PostMapping("user_add")
    public ModelAndView userAdd(ModelAndView modelAndView,HttpServletRequest request)
    {
        User user=new User();
        user.userValued(request.getParameterMap());
        boolean isSucc=userService.addUser(user);
        if (isSucc)
        {
            modelAndView.addObject("msg","添加用户成功!");
            modelAndView.setViewName("redirect:/admin/user_list");
        }
        else
        {
            modelAndView.addObject("u",user);
            modelAndView.addObject("failMsg","用户名或邮箱重复，请重新填写！");
            modelAndView.setViewName("admin/user_add");
        }
//        System.out.println("添加用户是否成功？"+isSucc);
        return modelAndView;
    }

    @PostMapping("user_reset")
    public ModelAndView userReset(ModelAndView modelAndView,HttpServletRequest request)
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        userService.updatePwd(username,password);
        modelAndView.addObject("msg","修改密码成功！");
        modelAndView.setViewName("redirect:/admin/user_list");
        return modelAndView;
    }

    @PostMapping("user_edit")
    public ModelAndView userEdit(ModelAndView modelAndView,User user)
    {
        System.out.println(user);
        User u=userService.findByUsername(user.getUsername());
        u.setName(user.getName());
        u.setPhone(user.getPhone());
        u.setAddress(user.getAddress());
        userService.save(u);

        modelAndView.addObject("msg","修改收货信息成功！");
        modelAndView.setViewName("redirect:/admin/user_list");
        return modelAndView;
    }

    @GetMapping("user_del")
    public ModelAndView userDel(ModelAndView modelAndView,HttpServletRequest request)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (userService.del(id))
        {
            modelAndView.addObject("msg","删除用户成功！");
            modelAndView.setViewName("redirect:/admin/user_list");
        }
        else
        {
            modelAndView.addObject("failMsg","删除用户失败！");
            modelAndView.setViewName("redirect:/admin/user_list");
        }
        return modelAndView;
    }

    @RequestMapping("logout")
    public ModelAndView logout(ModelAndView modelAndView,HttpServletRequest request)
    {
        request.getSession().invalidate();  //清空session里面的user信息
        modelAndView.setViewName("redirect:/fore/index");
        return modelAndView;
    }
}
