package com.springMvc.service;

import com.springMvc.dao.PatientMapper;
import com.springMvc.entity.po.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientMapper patientMapper;

    // 根据病历号获取病人信息
    public Patient getPatient(Integer medicalNo){
        return patientMapper.selectByPrimaryKey(medicalNo);
    }
}
