package com.springMvc.dao;

import com.springMvc.entity.po.DailyStatement;

public interface DailyStatementMapper {
    int deleteByPrimaryKey(Integer dailyId);

    int insert(DailyStatement record);

    int insertSelective(DailyStatement record);

    DailyStatement selectByPrimaryKey(Integer dailyId);

    int updateByPrimaryKeySelective(DailyStatement record);

    int updateByPrimaryKey(DailyStatement record);
}