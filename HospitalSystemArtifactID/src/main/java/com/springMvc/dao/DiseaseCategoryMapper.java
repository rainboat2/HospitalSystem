package com.springMvc.dao;

import com.springMvc.entity.po.DiseaseCategory;

public interface DiseaseCategoryMapper {
    int deleteByPrimaryKey(Integer diseCateId);

    int insert(DiseaseCategory record);

    int insertSelective(DiseaseCategory record);

    DiseaseCategory selectByPrimaryKey(Integer diseCateId);

    int updateByPrimaryKeySelective(DiseaseCategory record);

    int updateByPrimaryKey(DiseaseCategory record);
}