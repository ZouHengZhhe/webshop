package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-05  9:34
 */
@Repository
public interface RecommendRepo extends JpaRepository<Recommend,Integer>
{
    @Query(value = "select r from Recommend as r where goods_id=?1 and type=?2")
    Recommend findByGoodsIdAndType(Integer goodsId, Integer type);
}
