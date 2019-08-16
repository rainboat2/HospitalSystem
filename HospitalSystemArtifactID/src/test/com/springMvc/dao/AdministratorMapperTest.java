package com.springMvc.dao;

import com.springMvc.entity.po.Administrator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AdministratorMapperTest {

    private AdministratorMapper administratorMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        administratorMapper = applicationContext.getBean(AdministratorMapper.class);//在这里导入要测试的
    }

    @Test
    public void selectByPrimaryKey() {
        Administrator admin = administratorMapper.selectByPrimaryKey(1049696130);
        System.out.println(admin.getName());
    }
}