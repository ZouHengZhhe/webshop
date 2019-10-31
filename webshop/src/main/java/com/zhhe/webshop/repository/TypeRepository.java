package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 16:43
 */
@Repository
public interface TypeRepository extends JpaRepository<Type,Integer>
{
    @Query(value = "select name from type where id=?",nativeQuery = true)
    String selectTypeNameById(Integer id);
}
