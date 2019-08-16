package com.springMvc.dao;

import com.springMvc.entity.po.MedicalTechnicianApplication;
import com.springMvc.entity.po.MedicalTechnicianApplicationKey;

public interface MedicalTechnicianApplicationMapper {
    int deleteByPrimaryKey(MedicalTechnicianApplicationKey key);

    int insert(MedicalTechnicianApplication record);

    int insertSelective(MedicalTechnicianApplication record);

    MedicalTechnicianApplication selectByPrimaryKey(MedicalTechnicianApplicationKey key);

    int updateByPrimaryKeySelective(MedicalTechnicianApplication record);

    int updateByPrimaryKey(MedicalTechnicianApplication record);
}