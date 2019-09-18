package com.springMvc.dao;

import com.springMvc.entity.po.Drug;

import java.util.List;
import java.util.Map;

public interface DrugMapper {
    int deleteByPrimaryKey(Integer drugId);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(Integer drugId);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);

    List<Map<String, Object>> selectByKeyword(String keyword);
}