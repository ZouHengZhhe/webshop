package com.zhhe.webshop.ctrl.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-22  14:43
 */
@Controller
@RequestMapping("admin")
public class AdminToCtrl
{
    @RequestMapping("toUserAdd")
    public String toUserAdd()
    {
        return "admin/user_add";
    }

    @RequestMapping("toResetPwd")
    public String toResetPwd(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String email=request.getParameter("email");
        request.setAttribute("username",username);
        request.setAttribute("email",email);
        return "admin/user_reset";
    }

    @RequestMapping("toUserEdit")
    public String toEditShow(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        request.setAttribute("username",username);
        request.setAttribute("name",name);
        request.setAttribute("phone",phone);
        request.setAttribute("address",address);
        return "admin/user_edit";
    }
}
