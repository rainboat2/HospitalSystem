package com.springMvc.dao;

import com.springMvc.entity.po.CaseRecord;

public interface CaseRecordMapper {
    int deleteByPrimaryKey(Integer caseId);

    int insert(CaseRecord record);

    int insertSelective(CaseRecord record);

    CaseRecord selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(CaseRecord record);

    int updateByPrimaryKey(CaseRecord record);
}