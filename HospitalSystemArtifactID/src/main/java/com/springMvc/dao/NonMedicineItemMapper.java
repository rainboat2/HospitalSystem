package com.springMvc.dao;

import com.springMvc.entity.po.NonMedicineItem;

public interface NonMedicineItemMapper {
    int deleteByPrimaryKey(Integer nonMid);

    int insert(NonMedicineItem record);

    int insertSelective(NonMedicineItem record);

    NonMedicineItem selectByPrimaryKey(Integer nonMid);

    int updateByPrimaryKeySelective(NonMedicineItem record);

    int updateByPrimaryKey(NonMedicineItem record);
}