package com.springMvc.dao;

import com.springMvc.entity.po.HomePage;

public interface HomePageMapper {
    int deleteByPrimaryKey(Integer caseId);

    int insert(HomePage record);

    int insertSelective(HomePage record);

    HomePage selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(HomePage record);

    int updateByPrimaryKey(HomePage record);
}