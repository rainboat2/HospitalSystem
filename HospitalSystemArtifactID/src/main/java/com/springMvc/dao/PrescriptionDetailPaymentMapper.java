package com.springMvc.dao;

import com.springMvc.entity.po.PrescriptionDetailPayment;

public interface PrescriptionDetailPaymentMapper {
    int deleteByPrimaryKey(Integer presPayId);

    int insert(PrescriptionDetailPayment record);

    int insertSelective(PrescriptionDetailPayment record);

    PrescriptionDetailPayment selectByPrimaryKey(Integer presPayId);

    int updateByPrimaryKeySelective(PrescriptionDetailPayment record);

    int updateByPrimaryKey(PrescriptionDetailPayment record);
}