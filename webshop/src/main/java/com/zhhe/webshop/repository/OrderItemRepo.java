package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
//    @Query(value = "select * from order_item where order_id = ?",nativeQuery = true)
    @Query(value = "select new OrderItem(o.id,o.price,o.amount,o.goods_id,o.order_id,g.name) from OrderItem o,Goods g where o.goods_id=g.id and o.order_id=:orderId")
    List<OrderItem> getItemList(@Param("orderId")Integer orderId);

    @Query(value = "delete from order_item where order_id=?",nativeQuery = true)
    @Modifying
    void delByOrderId(Integer orderId);

//    void deleteByOrder_id(Integer orderId);
}
