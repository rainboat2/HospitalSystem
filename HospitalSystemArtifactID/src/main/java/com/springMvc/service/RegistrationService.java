package com.springMvc.service;

import com.springMvc.dao.OutpatientDoctorMapper;
import com.springMvc.dao.PatientMapper;
import com.springMvc.dao.RegistrationLevelMapper;
import com.springMvc.dao.RegistrationMapper;
import com.springMvc.entity.po.Patient;
import com.springMvc.entity.po.RegistrationLevel;
import com.springMvc.entity.vo.PatientForDoctor;
import com.springMvc.entity.vo.RegistrationDoctor;
import com.springMvc.entity.vo.RegistrationInfo;
import com.springMvc.entity.vo.WithdrawRegistrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegistrationService {

    // 打印费用
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

    // 该方法用于在退号时，查找指定病历号对应的挂号信息
    public Map<String, Object> getRegistration(int medicalNo){
        List<WithdrawRegistrationInfo> regList = registrationMapper.selectByMedicalNo(medicalNo);
        Map<String, Object> model = new HashMap<>();
        model.put("regList", regList);
        return model;
    }

    // 指定挂号id，进行退号操作，并返回挂号的结果
    public Map<String, Object> withdrawRegistration(Integer regId){
        Map<String, Object> info = new HashMap<>();
        info.put("regId", regId);
        info.put("success", null);
        registrationMapper.withdrawMedicalNo(info);
        return info;
    }

    // 查询指定医生需要看诊的人数
    public Map<String, Object> getPatientForDoctor(int odId){
        Map<String, Object> param = new HashMap<>();
        param.put("odId", odId);

        // 设置参数，分别查询未就诊和已诊断的病人
        param.put("state", "未就诊");
        List<PatientForDoctor> waitForDiagnose = patientMapper.selectByDoctor(param);
        param.put("state", "已诊断");
        List<PatientForDoctor> diagnosed = patientMapper.selectByDoctor(param);

        // 将查询结果放入Map并返回
        Map<String, Object> rs = new HashMap<>();
        rs.put("waitForDiagnose", waitForDiagnose);
        rs.put("diagnose", diagnosed);
        return rs;
    }

}
