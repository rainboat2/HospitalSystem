package com.springMvc.dao;

import com.springMvc.entity.po.PrescriptionTemplate;

public interface PrescriptionTemplateMapper {
    int deleteByPrimaryKey(String presTempName);

    int insert(PrescriptionTemplate record);

    int insertSelective(PrescriptionTemplate record);

    PrescriptionTemplate selectByPrimaryKey(String presTempName);

    int updateByPrimaryKeySelective(PrescriptionTemplate record);

    int updateByPrimaryKey(PrescriptionTemplate record);
}