package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.OrderItem;
import com.zhhe.webshop.bean.domain.OrderTable;
import com.zhhe.webshop.bean.model.Page;

import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-11  11:14
 */
public interface OrderService
{
    void addOrder(OrderTable orderTable);
    void addOrderItem(OrderItem orderItem);
    List<OrderTable> findAllByUserId(Integer userId);
    Page getOrderPage(int status,int pageNo);
    void updateStatus(int id,int status);
    void delOrder(int id);
    void delOrderItems(int id);
}
