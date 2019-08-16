package com.springMvc.dao;

import com.springMvc.entity.po.PrescriptionDetail;

public interface PrescriptionDetailMapper {
    int deleteByPrimaryKey(Integer presDetailId);

    int insert(PrescriptionDetail record);

    int insertSelective(PrescriptionDetail record);

    PrescriptionDetail selectByPrimaryKey(Integer presDetailId);

    int updateByPrimaryKeySelective(PrescriptionDetail record);

    int updateByPrimaryKey(PrescriptionDetail record);
}