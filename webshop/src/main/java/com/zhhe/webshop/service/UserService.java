package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.User;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-04  14:27
 */
public interface UserService
{
    Boolean addUser(User user);
    Boolean isUsernameExist(String username);
    Boolean isEmailExist(String email);
    User loginByUsername(String username,String password);
    User loginByEmail(String email,String password);
    User login(String ue,String password);
    void update(User user);
}
