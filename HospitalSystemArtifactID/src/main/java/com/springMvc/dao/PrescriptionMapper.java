package com.springMvc.dao;

import com.springMvc.entity.po.Prescription;
import com.springMvc.entity.vo.PrescriptionDrugs;

import java.util.List;
import java.util.Map;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer presId);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(Integer presId);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);

    void prescribeDrugs(PrescriptionDrugs prescriptionDrugs);

    List<Map<String, Object>> getDrugsForPay(Map<String, Object> info);
}