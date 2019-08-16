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

    public List<Department> getAllDepartment(){
        List<Department> list = departmentMapper.selectAllDepartment();
        logger.debug("查询所有部门，共找到" + list.size() + "个");
        return list;
    }

    public List<RegistrationLevel> getAllRegistrationLevel(){
        return registrationLevelMapper.getAllLevel();
    }

}
