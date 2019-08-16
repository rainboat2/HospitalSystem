package com.springMvc.controller;

import com.springMvc.entity.vo.RegistrationDoctor;
import com.springMvc.entity.vo.RegistrationInfo;
import com.springMvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/registration")
    @ResponseBody
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Map<String, String> registration(@RequestBody RegistrationInfo info){
        Map<String, String> rs = registrationService.registration(info);
        rs.put("fee", registrationService.countFee(info).toString());
        return rs;
    }

    @RequestMapping("/getDoctors")
    @ResponseBody
    public Map<String, Object> getDoctors
            (@RequestParam("deptId") int deptId, @RequestParam("reglCode") String reglCode){
        List<RegistrationDoctor> doctors = registrationService.getDoctors(deptId, reglCode);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("doctors", doctors);
        return map;
    }

    @RequestMapping("/getPatient")
    @ResponseBody
    public Map<String, Object> getPatient(@RequestParam("medicalNo") int medicalNo){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("patient", registrationService.getPatient(medicalNo));
        return map;
    }
}
