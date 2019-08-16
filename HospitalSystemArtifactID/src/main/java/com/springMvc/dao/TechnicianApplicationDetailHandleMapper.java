package com.springMvc.dao;

import com.springMvc.entity.po.TechnicianApplicationDetailHandle;
import com.springMvc.entity.po.TechnicianApplicationDetailHandleKey;

public interface TechnicianApplicationDetailHandleMapper {
    int deleteByPrimaryKey(TechnicianApplicationDetailHandleKey key);

    int insert(TechnicianApplicationDetailHandle record);

    int insertSelective(TechnicianApplicationDetailHandle record);

    TechnicianApplicationDetailHandle selectByPrimaryKey(TechnicianApplicationDetailHandleKey key);

    int updateByPrimaryKeySelective(TechnicianApplicationDetailHandle record);

    int updateByPrimaryKey(TechnicianApplicationDetailHandle record);
}