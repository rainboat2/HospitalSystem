package com.springMvc.service;

import com.springMvc.dao.DepartmentMapper;
import com.springMvc.dao.RegistrationLevelMapper;
import com.springMvc.entity.po.Department;
import com.springMvc.entity.po.RegistrationLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageJumpService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    RegistrationLevelMapper registrationLevelMapper;

    private Logger logger = LoggerFactory.getLogger(PageJumpService.class);

    // 查找所有的看诊科室
    public List<Department> getAllDepartment(){
        return departmentMapper.selectAllDepartment();
    }

    // 查找所有的挂号级别
    public List<RegistrationLevel> getAllRegistrationLevel(){
        return registrationLevelMapper.getAllLevel();
    }

}
