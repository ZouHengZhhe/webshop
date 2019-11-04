package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.User;
import com.zhhe.webshop.repository.UserRepository;
import com.zhhe.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-04  14:27
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Boolean addUser(User user)
    {
        if (isUsernameExist(user.getUsername()))
        {
            return false;
        }
        if (isEmailExist(user.getEmail()))
        {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    /**
     * @return false表示不存在用户名，可以添加新用户；
     */
    @Override
    public Boolean isUsernameExist(String username)
    {
        if (userRepository.findByUsername(username)==null)
        {
            return false;
        }
        return true;
    }

    /**
     * @return  false表示不存在用户名，可以添加新用户；
     */
    @Override
    public Boolean isEmailExist(String email)
    {
        if (userRepository.findByEmail(email)==null)
        {
            return false;
        }
        return true;
    }

    @Override
    public User loginByUsername(String username, String password)
    {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User loginByEmail(String email, String password)
    {
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User login(String ue, String password)
    {
        if (loginByUsername(ue,password)!=null)
        {
            return loginByUsername(ue,password);
        }
        if (loginByEmail(ue,password)!=null)
        {
            return loginByEmail(ue,password);
        }
        return null;
    }
}
