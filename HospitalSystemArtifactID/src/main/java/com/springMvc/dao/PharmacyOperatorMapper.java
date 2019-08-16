package com.springMvc.dao;

import com.springMvc.entity.po.PharmacyOperator;

public interface PharmacyOperatorMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(PharmacyOperator record);

    int insertSelective(PharmacyOperator record);

    PharmacyOperator selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(PharmacyOperator record);

    int updateByPrimaryKey(PharmacyOperator record);
}