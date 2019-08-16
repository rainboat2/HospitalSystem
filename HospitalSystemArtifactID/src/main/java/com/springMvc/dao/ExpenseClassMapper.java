package com.springMvc.dao;

import com.springMvc.entity.po.ExpenseClass;

public interface ExpenseClassMapper {
    int deleteByPrimaryKey(Integer expId);

    int insert(ExpenseClass record);

    int insertSelective(ExpenseClass record);

    ExpenseClass selectByPrimaryKey(Integer expId);

    int updateByPrimaryKeySelective(ExpenseClass record);

    int updateByPrimaryKey(ExpenseClass record);
}