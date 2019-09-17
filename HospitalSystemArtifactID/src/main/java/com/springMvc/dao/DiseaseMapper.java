package com.springMvc.dao;

import com.springMvc.entity.po.Disease;

import java.util.List;
import java.util.Map;

public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer diseId);

    int insert(Disease record);

    int insertSelective(Disease record);

    Disease selectByPrimaryKey(Integer diseId);

    int updateByPrimaryKeySelective(Disease record);

    int updateByPrimaryKey(Disease record);

    List<Map<String, Object>> selectByKeyword(String keyword);
}