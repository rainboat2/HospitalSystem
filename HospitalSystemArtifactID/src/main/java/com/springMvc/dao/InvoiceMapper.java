package com.springMvc.dao;

import com.springMvc.entity.po.Invoice;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer invId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(Integer invId);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}