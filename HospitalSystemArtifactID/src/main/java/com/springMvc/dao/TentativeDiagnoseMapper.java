package com.springMvc.dao;

import com.springMvc.entity.po.TentativeDiagnose;
import com.springMvc.entity.po.TentativeDiagnoseKey;

public interface TentativeDiagnoseMapper {
    int deleteByPrimaryKey(TentativeDiagnoseKey key);

    int insert(TentativeDiagnose record);

    int insertSelective(TentativeDiagnose record);

    TentativeDiagnose selectByPrimaryKey(TentativeDiagnoseKey key);

    int updateByPrimaryKeySelective(TentativeDiagnose record);

    int updateByPrimaryKey(TentativeDiagnose record);
}