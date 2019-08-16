package com.springMvc.dao;

import com.springMvc.entity.po.Patient;

public interface PatientMapper {
    int deleteByPrimaryKey(Integer medicalNo);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer medicalNo);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}