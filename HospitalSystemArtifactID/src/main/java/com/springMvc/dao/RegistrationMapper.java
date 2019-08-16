package com.springMvc.dao;

import com.springMvc.entity.po.Registration;
import com.springMvc.entity.vo.RegistrationInfo;

public interface RegistrationMapper {
    int deleteByPrimaryKey(Integer regId);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer regId);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);

    void registration(RegistrationInfo info);
}