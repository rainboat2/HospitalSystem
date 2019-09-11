package com.springMvc.dao;

import com.springMvc.entity.po.Patient;
import com.springMvc.entity.vo.PatientForDoctor;

import java.util.List;
import java.util.Map;

public interface PatientMapper {
    int deleteByPrimaryKey(Integer medicalNo);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer medicalNo);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

    /**
     * 查询医生对应的未就诊和已诊断的病人
     * @param map = {odId: ?, state: 未就诊/已诊断}
     * @return 未就诊或已诊断的病人集合
     */
    List<PatientForDoctor> selectByDoctor(Map<String, Object> map);
}