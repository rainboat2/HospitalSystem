package com.springMvc.service;

import com.springMvc.dao.*;
import com.springMvc.entity.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordChecker {

    private static final int ADMINISTRATOR = 0;
    private static final int CASHIER = 1;
    private static final int OUTPATIENT_DOCTOR = 2;
    private static final int MEDICAL_DOCTOR = 3;
    private static final int PHARMACY_OPERATOR = 4;

    @Autowired
    AdministratorMapper administratorMapper;

    @Autowired
    MedicalDoctorMapper medicalDoctorMapper;

    @Autowired
    OutpatientDoctorMapper outpatientDoctorMapper;

    @Autowired
    CashierMapper cashierMapper;

    @Autowired
    PharmacyOperatorMapper pharmacyOperatorMapper;

    // 用户名存在且密码正确才能成功通过
    public boolean check(int userId, String password, int type){
        switch (type){
            case ADMINISTRATOR:
                Administrator admin =  administratorMapper.selectByPrimaryKey(userId);
                return admin != null && password.equals(admin.getPassword());
            case CASHIER:
                Cashier cashier = cashierMapper.selectByPrimaryKey(userId);
                return cashier != null && password.equals(cashier.getPassword());
            case OUTPATIENT_DOCTOR:
                OutpatientDoctor doctor = outpatientDoctorMapper.selectByPrimaryKey(userId);
                return doctor != null && password.equals(doctor.getPassword());
            case MEDICAL_DOCTOR:
                MedicalDoctor doctor1 = medicalDoctorMapper.selectByPrimaryKey(userId);
                return doctor1 != null && password.equals(doctor1.getPassword());
            case PHARMACY_OPERATOR:
                PharmacyOperator operator = pharmacyOperatorMapper.selectByPrimaryKey(userId);
                return operator != null && password.equals(operator.getPassword());
            default:
                throw new RuntimeException("未知类型用户");
        }
    }
}