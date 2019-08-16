package com.springMvc.dao;

import com.springMvc.entity.po.HomePageTemplate;

public interface HomePageTemplateMapper {
    int deleteByPrimaryKey(String tempName);

    int insert(HomePageTemplate record);

    int insertSelective(HomePageTemplate record);

    HomePageTemplate selectByPrimaryKey(String tempName);

    int updateByPrimaryKeySelective(HomePageTemplate record);

    int updateByPrimaryKey(HomePageTemplate record);
}