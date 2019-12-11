package com.zhhe.webshop.util;

import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-10  9:36
 */
@Component
@Slf4j
public class MinioUtil
{
    private String url;
    private String username;
    private String password;
    private String bucketName;

    private MinioClient minioClient;

    public MinioUtil(@Value("${minio.url}")String url,@Value("${minio.username}")String username,@Value("${minio.password}")String password,@Value("${minio.bucketName}")String bucketName)
    {
        this.url=url;
        this.username=username;
        this.password=password;
        this.bucketName=bucketName;
        init();
    }

    public void init()
    {
        try
        {
            minioClient=new MinioClient(url,username,password);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //上传设备图片(默认存入webshop的bucketName)
    public boolean uploadImg(MultipartFile file,String fileName) throws Exception
    {
            boolean found = minioClient.bucketExists(bucketName);
            log.info("MinioUtil/uploadImg    found:"+minioClient.bucketExists(bucketName));
            if (!found)
            {
                minioClient.makeBucket(bucketName);
            }
            InputStream inputStream = file.getInputStream();
            String contentType = file.getContentType();
//            System.out.println("MinioUtil/uploadImg   contentType="+contentType);
            minioClient.putObject(bucketName, fileName, inputStream, contentType);

        return true;
    }

    public boolean uploadImg( InputStream inputStream,String contentType,String fileName) throws Exception
    {
        boolean found = minioClient.bucketExists(bucketName);
        log.info("MinioUtil/uploadImg    found:"+minioClient.bucketExists(bucketName));
        if (!found)
        {
            minioClient.makeBucket(bucketName);
        }
        minioClient.putObject(bucketName, fileName, inputStream, contentType);

        return true;
    }

    //返回图片的url
    public String getImgUrl(String imgName)
    {
        try
        {
            return minioClient.presignedGetObject(bucketName, imgName);
        }
        catch (Exception e)
        {
            return "获取图片失败:"+e.getMessage();
        }
    }

    public boolean delImg(String objName)
    {
        try
        {
            minioClient.removeObject(bucketName, objName);
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
