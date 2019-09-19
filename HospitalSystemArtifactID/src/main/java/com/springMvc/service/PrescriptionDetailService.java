package com.springMvc.service;

import com.springMvc.dao.PrescriptionDetailMapper;
import com.springMvc.entity.po.PrescriptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionDetailService {

    @Autowired
    private PrescriptionDetailMapper prescriptionDetailMapper;

    public Boolean changeState(List<Integer> presDetailIds, String state){
        for (int id : presDetailIds){
            PrescriptionDetail p = new PrescriptionDetail();
            p.setPresDetailId(id);
            p.setState(state);
            prescriptionDetailMapper.updateByPrimaryKeySelective(p);
        }
        return true;
    }
}
