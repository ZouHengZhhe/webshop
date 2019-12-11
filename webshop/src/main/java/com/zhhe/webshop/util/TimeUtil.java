package com.zhhe.webshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-10  9:49
 */
public class TimeUtil
{
    private static SimpleDateFormat df;

    static
    {
        df = new SimpleDateFormat("yyyyMMddHHmmssSSS"); //设置日期格式
    }

    //获取当前日期和时间（时间格式：2019-03-04 17:16:05）
    public static String getCurrentDateAndTime()
    {
        return df.format(new Date());
    }

}
