package com.springMvc.dao;

import com.springMvc.entity.po.MedicalDoctor;

public interface MedicalDoctorMapper {
    int deleteByPrimaryKey(Integer mdId);

    int insert(MedicalDoctor record);

    int insertSelective(MedicalDoctor record);

    MedicalDoctor selectByPrimaryKey(Integer mdId);

    int updateByPrimaryKeySelective(MedicalDoctor record);

    int updateByPrimaryKey(MedicalDoctor record);
}