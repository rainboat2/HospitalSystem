package com.springMvc.dao;

import com.springMvc.entity.po.Disease;

public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer diseId);

    int insert(Disease record);

    int insertSelective(Disease record);

    Disease selectByPrimaryKey(Integer diseId);

    int updateByPrimaryKeySelective(Disease record);

    int updateByPrimaryKey(Disease record);
}