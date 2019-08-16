package com.springMvc.dao;

import com.springMvc.entity.po.MedicalTechnicianTemplate;

public interface MedicalTechnicianTemplateMapper {
    int deleteByPrimaryKey(String mtTempName);

    int insert(MedicalTechnicianTemplate record);

    int insertSelective(MedicalTechnicianTemplate record);

    MedicalTechnicianTemplate selectByPrimaryKey(String mtTempName);

    int updateByPrimaryKeySelective(MedicalTechnicianTemplate record);

    int updateByPrimaryKey(MedicalTechnicianTemplate record);
}