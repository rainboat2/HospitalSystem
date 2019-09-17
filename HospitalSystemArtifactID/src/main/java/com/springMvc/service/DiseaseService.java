package com.springMvc.service;

import com.springMvc.dao.DiseaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseMapper diseaseMapper;

    public List<Map<String, Object>> getDisease(String keyword){
        return diseaseMapper.selectByKeyword(keyword);
    }
}
