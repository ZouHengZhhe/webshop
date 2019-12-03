package com.zhhe.webshop.ctrl;

import com.zhhe.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-21  16:54
 */
@RestController
public class TestCtrl
{
    @Autowired
    private OrderRepository repo;

    @RequestMapping("test")
    public Object test()
    {
        return repo.test();
    }
}
