package com.springMvc.dao;

import com.springMvc.entity.po.PrescriptionTemplateDetail;
import com.springMvc.entity.po.PrescriptionTemplateDetailKey;

public interface PrescriptionTemplateDetailMapper {
    int deleteByPrimaryKey(PrescriptionTemplateDetailKey key);

    int insert(PrescriptionTemplateDetail record);

    int insertSelective(PrescriptionTemplateDetail record);

    PrescriptionTemplateDetail selectByPrimaryKey(PrescriptionTemplateDetailKey key);

    int updateByPrimaryKeySelective(PrescriptionTemplateDetail record);

    int updateByPrimaryKey(PrescriptionTemplateDetail record);
}