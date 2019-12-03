package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-04  14:24
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username,String password);
    User findByEmailAndPassword(String email,String password);

    @Query(nativeQuery = true,value = "select username from user where id=?")
    String findUsernameById(int id);

    @Query(nativeQuery = true,value = "select id,username,email,name,phone,address from user limit ?,?")
    List<Map<String,String>> getUserPage(int startIndex, int pageSize);

    @Query(nativeQuery = true,value = "select count(*) from user ")
    int getUserCount();

    @Query(nativeQuery = true,value = "update user set password =? where username=?")
    @Modifying
    void updatePwd(String password,String username);
}
