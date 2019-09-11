package com.springMvc.controller;

import com.springMvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class OutpatientDoctor {

    @Autowired
    RegistrationService registrationService;

    // 获取医生对应的未就诊和已诊断的病人
    @RequestMapping("/getPatientForDoctor")
    @ResponseBody
    public Map<String, Object> getPatientForDoctor(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        int odId = (int) session.getAttribute("userId");
        return registrationService.getPatientForDoctor(odId);
    }
}
