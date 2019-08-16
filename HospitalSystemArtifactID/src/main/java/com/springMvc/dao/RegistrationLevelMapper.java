package com.springMvc.dao;

import com.springMvc.entity.po.RegistrationLevel;

import java.util.List;

public interface RegistrationLevelMapper {
    int deleteByPrimaryKey(String reglCode);

    int insert(RegistrationLevel record);

    int insertSelective(RegistrationLevel record);

    RegistrationLevel selectByPrimaryKey(String reglCode);

    int updateByPrimaryKeySelective(RegistrationLevel record);

    int updateByPrimaryKey(RegistrationLevel record);

    List<RegistrationLevel> getAllLevel();
}