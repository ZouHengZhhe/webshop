package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.OrderItem;
import com.zhhe.webshop.bean.domain.OrderTable;

import java.util.List;

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
}
