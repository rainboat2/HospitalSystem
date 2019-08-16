package com.springMvc.dao;

import com.springMvc.entity.vo.RegistrationInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class RegistrationMapperTest {

    private RegistrationMapper registrationMapper;

    @Before
    public void setUp(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        registrationMapper = applicationContext.getBean(RegistrationMapper.class);
    }

    @Test
    public void registration() {
        RegistrationInfo info = new RegistrationInfo();
        info.setAddress("23");
        info.setBirthday(new Date(System.currentTimeMillis()));
        info.setDeptId(1);
        info.setGender(false);
        info.setOdId(1);
        info.setPatName("测试");
        info.setPrinted(false);
        info.setReglCode("zjh");
        info.setPatId("21");
        info.setType("自费");
        info.setcId(1);

        registrationMapper.registration(info);
        System.out.println(info.getSuccess());
        System.out.println(info.getMedicalNo());
        System.out.println(info.getRegId());
    }
}