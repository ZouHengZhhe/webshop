package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 13:32
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer>
{
    @Query(value = "select g.id,g.name,g.cover,g.price,t.name typename from recommend r ,goods g ,type t where r.type=? and r.goods_id=g.id and g.type_id=t.id",nativeQuery = true)
    List<Map<String,Object>> getGoodsList(int recommendType);

    @Query(value = "select g.id,g.name,g.cover,g.price from recommend r ,goods g where r.type=1 and r.goods_id=g.id limit 1 ",nativeQuery = true)
    Map<String,Object> getScrollGoods();
}
