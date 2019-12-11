package com.zhhe.webshop.service.impl;

import com.zhhe.webshop.bean.domain.Type;
import com.zhhe.webshop.repository.TypeRepository;
import com.zhhe.webshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public String getTypeNameById(Integer id)
    {
        return typeRepository.selectTypeNameById(id);
    }

    @Override
    @Transactional
    public boolean addType(String name)
    {
        try
        {
            Type type=new Type();
            type.setName(name);
            typeRepository.save(type);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean delType(Integer id)
    {
        try
        {
            typeRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean editType(Integer id, String name)
    {
        try
        {
            Type type=typeRepository.findById(id).get();
            type.setName(name);
            typeRepository.save(type);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
