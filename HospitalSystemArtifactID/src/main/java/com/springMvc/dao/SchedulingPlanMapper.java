package com.springMvc.dao;

import com.springMvc.entity.po.SchedulingPlan;
import com.springMvc.entity.po.SchedulingPlanKey;

public interface SchedulingPlanMapper {
    int deleteByPrimaryKey(SchedulingPlanKey key);

    int insert(SchedulingPlan record);

    int insertSelective(SchedulingPlan record);

    SchedulingPlan selectByPrimaryKey(SchedulingPlanKey key);

    int updateByPrimaryKeySelective(SchedulingPlan record);

    int updateByPrimaryKey(SchedulingPlan record);
}