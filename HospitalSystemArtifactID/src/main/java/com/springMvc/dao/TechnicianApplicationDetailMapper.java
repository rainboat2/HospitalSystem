package com.springMvc.dao;

import com.springMvc.entity.po.TechnicianApplicationDetail;

public interface TechnicianApplicationDetailMapper {
    int deleteByPrimaryKey(Integer applDetailId);

    int insert(TechnicianApplicationDetail record);

    int insertSelective(TechnicianApplicationDetail record);

    TechnicianApplicationDetail selectByPrimaryKey(Integer applDetailId);

    int updateByPrimaryKeySelective(TechnicianApplicationDetail record);

    int updateByPrimaryKey(TechnicianApplicationDetail record);
}