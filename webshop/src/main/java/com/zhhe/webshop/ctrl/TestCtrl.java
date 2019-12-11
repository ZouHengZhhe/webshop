package com.zhhe.webshop.ctrl;

import com.zhhe.webshop.bean.domain.Goods;
import com.zhhe.webshop.bean.domain.User;
import com.zhhe.webshop.repository.GoodsRepository;
import com.zhhe.webshop.repository.OrderRepository;
import com.zhhe.webshop.service.GoodsService;
import com.zhhe.webshop.util.MinioUtil;
import com.zhhe.webshop.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-21  16:54
 */
@RestController
public class TestCtrl
{
    @Autowired
    private OrderRepository repo;

    @RequestMapping("test")
    public Object test()
    {
        return repo.test();
    }

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("changeImage")
    @Transactional
    public String chageImage() throws Exception
    {
        List<Integer> idList=goodsRepository.findAllId();
        for (Integer id:idList)
        {
            Goods goods=goodsRepository.findById(id).get();
            String coverName=goodsRepository.getCoverName(id);
            String img1Name=goodsRepository.getImg1Name(id);
            String img2Name=goodsRepository.getImg2Name(id);
            String[] nameArray=new String[3];
            nameArray[0]=coverName;
            nameArray[1]=img1Name;
            nameArray[2]=img2Name;

            for (int i=0;i<3;i++)
            {
                if (!nameArray[i].substring(0,1).equals("/"))
                {
                    break;
                }
                ClassPathResource resource = new ClassPathResource("static/fore" +nameArray[i]);
                // 获取文件流
                InputStream inputStream = resource.getInputStream();
                File file=resource.getFile();
                Path path = Paths.get(file.getPath());
                String contentType = Files.probeContentType(path);
                String fileName= Util.getName(file);
                minioUtil.uploadImg(inputStream,contentType,fileName);
                inputStream.close();
                switch (i)
                {
                    case 0:
                        goods.setCover(fileName);
                        break;
                    case 1:
                        goods.setImage1(fileName);
                        break;
                    case 2:
                        goods.setImage2(fileName);
                        break;
                }
            }

            goodsRepository.save(goods);
        }


        return "succ";
    }

    public static void main(String[] args)
    {
        String name="/picture/8-1.jpg";
        if (name.substring(0,1).equals("/"))
        {
            System.out.println("成功");
        }
        System.out.println(name.substring(0,1));
    }
}
