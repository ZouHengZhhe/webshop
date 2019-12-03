package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.OrderItem;
import com.zhhe.webshop.bean.domain.OrderTable;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.repository.GoodsRepository;
import com.zhhe.webshop.repository.OrderItemRepo;
import com.zhhe.webshop.repository.OrderRepository;
import com.zhhe.webshop.repository.UserRepository;
import com.zhhe.webshop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private UserRepository userRepository;

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
        List<OrderTable> list = orderRepository.findAllByUserId(userId);
        list.forEach(t -> {
            t.setItemList(orderItemRepo.getItemList(t.getId()));
            t.getItemList().forEach(x -> {
                x.setGoods(goodsRepository.findById(x.getGoods_id()).get());
            });
        });

        return list;
    }

    @Override
    public Page getOrderPage(int status, int pageNo)
    {
        Page page = new Page();
        page.setPageNumber(pageNo);
        int pageSize = 10;
        page.setPageSize(pageSize);
        List list;
        int startIndex = (pageNo - 1) * pageSize;
        if (status == 0)
        {
            page.setTotalCount(orderRepository.getAllOrdersCount());
            list = orderRepository.findAllOrderList(startIndex, pageSize);
        }
        else
        {
            page.setTotalCount(orderRepository.getOrdersCount(status));
            list = orderRepository.findStatusOrderList(status, startIndex, pageSize);
        }

        list.forEach(x -> {
            OrderTable orderTable= (OrderTable) x;

//            long startTime0=System.currentTimeMillis();
            String username=userRepository.findUsernameById(orderTable.getUser_id());
//            long diff0=System.currentTimeMillis()-startTime0;
//            log.info("查询用户名需要的时间："+String.valueOf(diff0));

            orderTable.setUsername(username);
            orderTable.setItemList(orderItemRepo.getItemList(orderTable.getId()));
        });

        page.setPageSizeAndTotalCount(pageSize, page.getTotalCount());
        page.setList(list);
        return page;
    }

    @Override
    @Transactional
    public void updateStatus(int id, int status)
    {
        OrderTable orderTable=orderRepository.findById(id).get();
        orderTable.setStatus(status);
        orderRepository.save(orderTable);
    }

    @Override
    @Transactional
    public void delOrder(int id)
    {
        delOrderItems(id);
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delOrderItems(int id)
    {
        orderItemRepo.delByOrderId(id);
    }
}

