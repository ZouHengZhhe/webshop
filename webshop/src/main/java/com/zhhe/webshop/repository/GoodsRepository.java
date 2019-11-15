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

//    分页查询所有商品
    @Query(value = "select * from goods limit ?,?",nativeQuery = true)
    List<Goods> findAllGoodsList(int startIndex,int pageSize);

//    分页查询某个类型的商品
    @Query(value = "select * from goods where type_id=? limit ?,?",nativeQuery = true)
    List<Goods> findTypeGoodsList(int type_id,int startIndex,int pageSize);

    @Query(value = "select count(*) from goods",nativeQuery = true)
    int getAllGoodsCount();

    @Query(value = "select count(*) from goods where type_id=?",nativeQuery = true)
    int getTypeGoodsCount(int typeId);

    //分页查询热销、新品商品
    @Query(value = "select * from goods g,recommend r where r.type=? and g.type_id=r.goods_id limit ?,?",nativeQuery = true)
    List<Goods> getGoodsRecommendList(int typeId,int startIndex,int pageSize);

    //分页查询热销、新品商品总数
    @Query(value = "select count(*) from goods where type_id=?",nativeQuery = true)
    int getGoodsRecommendCount(int typeId);

    //搜索商品，得到商品总数量
    @Query(value = "select count(*) from goods where name like %?%",nativeQuery = true)
    int fuzzySearchCount(String keyword);

    @Query(value = "select * from goods where name like %?% limit ?,?",nativeQuery = true)
    List<Goods> fuzzySearchGoods(String keyword,int startIndex,int pageSize);
}
