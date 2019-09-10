package com.springMvc.dao;

import com.springMvc.entity.po.Registration;
import com.springMvc.entity.vo.RegistrationInfo;
import com.springMvc.entity.vo.WithdrawRegistrationInfo;

import java.util.List;
import java.util.Map;

public interface RegistrationMapper {
    int deleteByPrimaryKey(Integer regId);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer regId);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);

    // 调用存储过程，进行挂号
    void registration(RegistrationInfo info);

    // 根据病历号，查找所有的挂号信息
    List<WithdrawRegistrationInfo> selectByMedicalNo(Integer medicalNO);

    // 根据病历号进行退号
    void withdrawMedicalNo(Map<String, Object> info);
}