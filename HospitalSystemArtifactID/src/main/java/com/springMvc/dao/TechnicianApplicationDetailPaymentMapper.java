package com.springMvc.dao;

import com.springMvc.entity.po.TechnicianApplicationDetailPayment;

public interface TechnicianApplicationDetailPaymentMapper {
    int deleteByPrimaryKey(Integer applPayId);

    int insert(TechnicianApplicationDetailPayment record);

    int insertSelective(TechnicianApplicationDetailPayment record);

    TechnicianApplicationDetailPayment selectByPrimaryKey(Integer applPayId);

    int updateByPrimaryKeySelective(TechnicianApplicationDetailPayment record);

    int updateByPrimaryKey(TechnicianApplicationDetailPayment record);
}