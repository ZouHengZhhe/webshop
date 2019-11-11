package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
