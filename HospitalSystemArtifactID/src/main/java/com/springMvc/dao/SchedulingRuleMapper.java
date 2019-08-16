package com.springMvc.dao;

import com.springMvc.entity.po.SchedulingRule;

public interface SchedulingRuleMapper {
    int deleteByPrimaryKey(Integer shedId);

    int insert(SchedulingRule record);

    int insertSelective(SchedulingRule record);

    SchedulingRule selectByPrimaryKey(Integer shedId);

    int updateByPrimaryKeySelective(SchedulingRule record);

    int updateByPrimaryKey(SchedulingRule record);
}