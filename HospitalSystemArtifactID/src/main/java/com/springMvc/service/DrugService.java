package com.springMvc.service;

import com.springMvc.dao.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DrugService {

    @Autowired
    private DrugMapper drugMapper;

    public List<Map<String, Object>> getDrugs(String keyword){
        return drugMapper.selectByKeyword(keyword);
    }
}
