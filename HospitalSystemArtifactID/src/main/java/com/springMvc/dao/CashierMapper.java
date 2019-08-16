package com.springMvc.dao;

import com.springMvc.entity.po.Cashier;

public interface CashierMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Cashier record);

    int insertSelective(Cashier record);

    Cashier selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Cashier record);

    int updateByPrimaryKey(Cashier record);
}