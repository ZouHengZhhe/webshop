package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.OrderItem;
import com.zhhe.webshop.bean.domain.OrderTable;
import com.zhhe.webshop.repository.GoodsRepository;
import com.zhhe.webshop.repository.OrderItemRepo;
import com.zhhe.webshop.repository.OrderRepository;
import com.zhhe.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-11  11:14
 */
@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    @Transactional
    public void addOrder(OrderTable orderTable)
    {
        orderRepository.save(orderTable);
    }

    @Override
    public void addOrderItem(OrderItem orderItem)
    {
        orderItemRepo.save(orderItem);
    }

    @Override
    public List<OrderTable> findAllByUserId(Integer userId)
    {
        List<OrderTable> list=orderRepository.findAllByUserId(userId);
        list.forEach(t-> {
            t.setItemList(orderItemRepo.getItemList(t.getId()));
            t.getItemList().forEach(x->{
                x.setGoods(goodsRepository.findById(x.getGoods_id()).get());
            });
        });

        return list;
    }
}
