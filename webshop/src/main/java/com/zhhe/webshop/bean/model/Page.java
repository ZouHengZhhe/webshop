package com.zhhe.webshop.bean.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:分页的数据模型
 *Date:2019-10-30 16:52
 */
@Getter
@Setter
public class Page
{
    private int pageNumber; //当前是第几页
    private int pageSize;   //每一页显示多少条数据
    private int totalCount; //总记录数 数据总个数
    private int totalPage;  //总页数
    private List<Object> list;

    public void setPageSizeAndTotalCount(int pageSize,int totalCount)
    {
        //根据每页显示的数据和总记录数算出总页数
        totalPage= (int) Math.ceil((float)totalCount/pageSize);
    }
}
