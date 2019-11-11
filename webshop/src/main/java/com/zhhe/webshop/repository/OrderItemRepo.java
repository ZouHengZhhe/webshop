package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-11  11:31
 */
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer>
{
    @Query(value = "select * from order_item where order_id = ?",nativeQuery = true)
    List<OrderItem> getItemList(Integer orderId);
}
