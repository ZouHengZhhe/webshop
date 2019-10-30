package com.zhhe.webshop.freemarker;

import com.zhhe.webshop.service.TypeService;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-10-30 16:42
 */
@Configuration
public class FreemarkerConfig
{
    @Autowired
    private freemarker.template.Configuration configuration;
    @Autowired
    private TypeService typeService;

    @PostConstruct
    public void setVariable() throws TemplateModelException
    {
        configuration.setSharedVariable("typesList", typeService.findAll());
    }
}
