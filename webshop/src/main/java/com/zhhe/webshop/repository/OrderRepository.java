package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-11  11:05
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderTable, Integer>
{
    @Query(value = "select * from order_table where user_id=? order by datetime desc ",nativeQuery = true)
    List<OrderTable> findAllByUserId(Integer userId);

    @Query(value = "select count(*) from order_table",nativeQuery = true)
    int getAllOrdersCount();

    @Query(value = "select count(*) from order_table where status=? ",nativeQuery = true)
    int getOrdersCount(int status);

    @Query(value = "select * from order_table order by datetime desc limit ?,?",nativeQuery = true)
//    @Query(value = "select new com.zhhe.webshop.bean.domain.OrderTable(o.id,o.total,o.status,o.address,o.paytype,o.datetime,u.username) from OrderTable as o,User u where o.user_id=u.id")
    List<OrderTable> findAllOrderList(int startIndex,int pageSize);

    @Query(value = "select * from order_table where status=? order by datetime desc limit ?,?",nativeQuery = true)
//    @Query(value = "SELECT o.id,o.total,o.status,o.address,o.paytype,o.datetime,u.username FROM order_table o,user u where o.status=? and o.user_id=u.id limit ?,?",nativeQuery = true)
    List<OrderTable> findStatusOrderList(int status,int startIndex,int pageSize);

    @Query(value = "select new com.zhhe.webshop.bean.domain.OrderTable(o.id,o.total,o.status,o.address,o.paytype,o.datetime,u.username) from OrderTable as o,User u where o.user_id=u.id")
    List<OrderTable> test();


}
