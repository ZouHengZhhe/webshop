package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.Type;
import com.zhhe.webshop.repository.TypeRepository;
import com.zhhe.webshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 16:44
 */
@Service
public class TypeServiceImpl implements TypeService
{
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findAll()
    {
        return typeRepository.findAll();
    }
}
