package com.zhhe.webshop.repository;

import com.zhhe.webshop.bean.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
