package com.springMvc.dao;

import com.springMvc.entity.po.WriteBackInvoice;

public interface WriteBackInvoiceMapper {
    int deleteByPrimaryKey(Integer wbInvId);

    int insert(WriteBackInvoice record);

    int insertSelective(WriteBackInvoice record);

    WriteBackInvoice selectByPrimaryKey(Integer wbInvId);

    int updateByPrimaryKeySelective(WriteBackInvoice record);

    int updateByPrimaryKey(WriteBackInvoice record);
}