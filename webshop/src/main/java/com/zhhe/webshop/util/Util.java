package com.zhhe.webshop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-12-10  9:56
 */
@Component
public class Util
{
    /**
     * 根据当前时间，设置文件名字
     * @param file 上传的文件，根据该文件获取文件的后缀
     * @return 新的文件名
     */
    public static String getName(MultipartFile file)
    {
        String fileOriName = file.getOriginalFilename();
        return analysisName(fileOriName);
    }
    public static String getName(File file)
    {
        String fileOriName = file.getName();
        return analysisName(fileOriName);
    }

    private static String analysisName(String fileOriName)
    {
        String[] array=fileOriName.split("\\.");
        String fileName=System.nanoTime()+"."+array[1];
        System.out.println("fileName:"+fileName);
        return fileName;
    }

}
