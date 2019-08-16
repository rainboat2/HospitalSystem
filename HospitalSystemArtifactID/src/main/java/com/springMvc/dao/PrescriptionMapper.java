package com.springMvc.dao;

import com.springMvc.entity.po.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer presId);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(Integer presId);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
}