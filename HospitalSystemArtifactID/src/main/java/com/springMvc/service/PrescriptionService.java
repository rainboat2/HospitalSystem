package com.springMvc.service;

import com.springMvc.dao.PrescriptionDetailMapper;
import com.springMvc.dao.PrescriptionMapper;
import com.springMvc.entity.vo.PrescriptionDrugs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrescriptionService {

    @Autowired
    PrescriptionMapper prescriptionMapper;

    public void prescribeDrugs(PrescriptionDrugs prescriptionDrugs){
        prescriptionMapper.prescribeDrugs(prescriptionDrugs);
    }

    public List<Map<String, Object>> getDrugsForPay(Map<String, Object> info){
        return prescriptionMapper.getDrugsForPay(info);
    }
}
