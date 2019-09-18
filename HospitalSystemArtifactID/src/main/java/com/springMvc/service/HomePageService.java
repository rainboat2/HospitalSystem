package com.springMvc.service;

import com.springMvc.dao.HomePageMapper;
import com.springMvc.entity.vo.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;

    // 传入病历首页的信息，完成医生看诊功能
    public void see(MedicalRecord medicalRecord){
        homePageMapper.see(medicalRecord);
    }
}
