package com.zhhe.webshop.ctrl.admin;

import com.zhhe.webshop.filter.Power;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-15  17:02
 */
@Controller
@RequestMapping("admin")
public class AdminToController
{
    @Power
    @RequestMapping("index")
    public String index(HttpServletResponse response)
    {
        return "admin/index";
    }
}
