package com.springMvc.service;

import com.springMvc.dao.OutpatientDoctorMapper;
import com.springMvc.dao.PatientMapper;
import com.springMvc.dao.RegistrationLevelMapper;
import com.springMvc.dao.RegistrationMapper;
import com.springMvc.entity.po.Patient;
import com.springMvc.entity.po.RegistrationLevel;
import com.springMvc.entity.vo.RegistrationDoctor;
import com.springMvc.entity.vo.RegistrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegistrationService {

    private static final BigDecimal PRINT_FEE = new BigDecimal(1);

    @Autowired
    private OutpatientDoctorMapper doctorMapper;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Autowired
    private RegistrationLevelMapper registrationLevelMapper;

    // 查询门诊医生的信息
    public List<RegistrationDoctor> getDoctors(int deptId, String reglCode){
        return doctorMapper.selectDoctors(deptId, reglCode);
    }

    // 根据病历号查找患者信息
    public Patient getPatient(int medicalNo){
        return patientMapper.selectByPrimaryKey(medicalNo);
    }

    // 提供挂号信息，进行挂号，返回挂号是否成功，挂号id，患者病历号
    public Map<String, String> registration(RegistrationInfo info){
        registrationMapper.registration(info);
        Map<String, String> rs = new HashMap<String, String>();
        rs.put("success", info.getSuccess().toString());
        rs.put("regId", info.getRegId().toString());
        rs.put("medicalNo", info.getMedicalNo().toString());
        return rs;
    }

    // 根据挂号信息，计算挂号所需的费用
    public BigDecimal countFee(RegistrationInfo info){
        RegistrationLevel level = registrationLevelMapper.selectByPrimaryKey(info.getReglCode());
        BigDecimal rs = level.getFee();
        return (info.getPrinted())? rs.add(PRINT_FEE) : rs;
    }
}
