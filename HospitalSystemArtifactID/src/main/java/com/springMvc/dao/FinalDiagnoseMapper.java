package com.springMvc.dao;

import com.springMvc.entity.po.FinalDiagnose;
import com.springMvc.entity.po.FinalDiagnoseKey;

public interface FinalDiagnoseMapper {
    int deleteByPrimaryKey(FinalDiagnoseKey key);

    int insert(FinalDiagnose record);

    int insertSelective(FinalDiagnose record);

    FinalDiagnose selectByPrimaryKey(FinalDiagnoseKey key);

    int updateByPrimaryKeySelective(FinalDiagnose record);

    int updateByPrimaryKey(FinalDiagnose record);
}