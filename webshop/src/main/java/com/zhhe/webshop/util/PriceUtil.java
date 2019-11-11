package com.zhhe.webshop.util;

import java.math.BigDecimal;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-08  16:34
 */
public class PriceUtil
{
    public static float add(float a,float b)
    {
        BigDecimal bigA=new BigDecimal(Float.toString(a));
        BigDecimal bigB=new BigDecimal(Float.toString(b));
        return bigA.add(bigB).floatValue();
    }
    public static double add(double a,double b)
    {
        BigDecimal bigA=new BigDecimal(Double.toString(a));
        BigDecimal bigB=new BigDecimal(Double.toString(b));
        return bigA.add(bigB).doubleValue();
    }

    public static float subtract(float a,float b)
    {
        BigDecimal bigA=new BigDecimal(Float.toString(a));
        BigDecimal bigB=new BigDecimal(Float.toString(b));
        return bigA.subtract(bigB).floatValue();
    }
    public static double subtract(double a,double b)
    {
        BigDecimal bigA=new BigDecimal(Double.toString(a));
        BigDecimal bigB=new BigDecimal(Double.toString(b));
        return bigA.subtract(bigB).doubleValue();
    }
}