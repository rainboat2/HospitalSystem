package com.springMvc.controller;

import com.springMvc.entity.po.Department;
import com.springMvc.entity.po.RegistrationLevel;
import com.springMvc.service.PageJumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageJumpController {

    @Autowired
    private PageJumpService pageJumpService;

    @RequestMapping(value = "/cashier", method = RequestMethod.GET)
    public Map<String, Object> getCashierPage(){
        // 需要返回所有的科室、挂号级别
        List<Department> departmentList = pageJumpService.getAllDepartment();
        List<RegistrationLevel> registrationLevelList = pageJumpService.getAllRegistrationLevel();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("departmentList", departmentList);
        map.put("registrationLevelList", registrationLevelList);
        return map;
    }

    @RequestMapping(value = "/withdrawRegistration", method = RequestMethod.GET)
    public String getReturnPaymentPage(){
        return "withdrawRegistration";
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public String getDoctorPage(){
        return "doctor";
    }
}
