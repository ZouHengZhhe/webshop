package com.zhhe.webshop.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhhe.webshop.bean.domain.User;
import com.zhhe.webshop.bean.model.Page;
import com.zhhe.webshop.repository.UserRepository;
import com.zhhe.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        user.setIsadmin(false);
        user.setIsadmin(false);
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

    @Override
    @Transactional
    public void update(User user)
    {
        userRepository.save(user);
    }

    @Override
    public Page getUserPage(int pageNo)
    {
        Page page = new Page();
        page.setPageNumber(pageNo);
        int pageSize = 10;
        page.setPageSize(pageSize);
        int startIndex = (pageNo - 1) * pageSize;
        List<Map<String,String>> listMap=userRepository.getUserPage(startIndex, pageSize);
        List list = new ArrayList();
        listMap.forEach(x->{
            String json = JSON.toJSONString(x);
            User u=JSON.parseObject(json,User.class);
            list.add(u);
        });
        page.setTotalCount(userRepository.getUserCount());
        page.setPageSizeAndTotalCount(pageSize, page.getTotalCount());
        page.setList(list);
        return page;
    }

    @Override
    @Transactional
    public void updatePwd(String username, String password)
    {
        userRepository.updatePwd(password,username);
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user)
    {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean del(Integer id)
    {
        try
        {
            userRepository.deleteById(id);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

}
