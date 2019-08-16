package com.springMvc.dao;

import com.springMvc.entity.po.MedicalTechnicianTemplateDetail;
import com.springMvc.entity.po.MedicalTechnicianTemplateDetailKey;

public interface MedicalTechnicianTemplateDetailMapper {
    int deleteByPrimaryKey(MedicalTechnicianTemplateDetailKey key);

    int insert(MedicalTechnicianTemplateDetail record);

    int insertSelective(MedicalTechnicianTemplateDetail record);

    MedicalTechnicianTemplateDetail selectByPrimaryKey(MedicalTechnicianTemplateDetailKey key);

    int updateByPrimaryKeySelective(MedicalTechnicianTemplateDetail record);

    int updateByPrimaryKey(MedicalTechnicianTemplateDetail record);
}