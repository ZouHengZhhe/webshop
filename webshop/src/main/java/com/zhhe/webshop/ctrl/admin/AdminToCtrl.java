package com.zhhe.webshop.ctrl.admin;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.Type;
import com.zhhe.webshop.filter.Power;
import com.zhhe.webshop.service.GoodsService;
import com.zhhe.webshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-22  14:43
 */
@Controller
@RequestMapping("admin")
public class AdminToCtrl
{
    @Autowired
    private TypeService typeService;
    @Autowired
    private GoodsService goodsService;

    @Power
    @RequestMapping("toUserAdd")
    public String toUserAdd()
    {
        return "admin/user_add";
    }

    @Power
    @RequestMapping("toResetPwd")
    public String toResetPwd(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String email=request.getParameter("email");
        request.setAttribute("username",username);
        request.setAttribute("email",email);
        return "admin/user_reset";
    }

    @Power
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

    @Power
    @RequestMapping("toTypeEdit")
    public String toTypeEdit(HttpServletRequest request)
    {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        request.setAttribute("id",id);
        request.setAttribute("name",name);
        return "admin/type_edit";
    }

    @Power
    @RequestMapping("index")
    public String index(HttpServletResponse response)
    {
        return "admin/index";
    }

    @Power
    @RequestMapping("toGoodsAdd")
    public String toGoodsAdd(HttpServletRequest request)
    {
        List<Type> types=typeService.findAll();
        request.setAttribute("types",types);
        return "admin/goods_add";
    }

    @Power
    @RequestMapping("toGoodsEdit")
    public String toGoodsEdit(HttpServletRequest request)
    {
        Integer goodsId=Integer.parseInt(request.getParameter("id"));
        Goods goods=goodsService.getGoodsWithUrl(goodsId);
        request.setAttribute("goods",goods);
        List<Type> types=typeService.findAll();
        request.setAttribute("types",types);
        return "admin/goods_edit";
    }
}
