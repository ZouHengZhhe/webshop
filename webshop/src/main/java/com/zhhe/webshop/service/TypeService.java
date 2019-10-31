package com.zhhe.webshop.service;

import com.zhhe.webshop.bean.domain.Type;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 16:43
 */
public interface TypeService
{
    List<Type> findAll();
    String getTypeNameById(Integer id);
}
