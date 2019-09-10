package com.springMvc.controller;

import com.springMvc.entity.po.Patient;
import com.springMvc.entity.po.Registration;
import com.springMvc.entity.vo.RegistrationDoctor;
import com.springMvc.entity.vo.RegistrationInfo;
import com.springMvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本控制类用于处理来自挂号/退号页面的请求
 */
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

    //  根据病历号查找患者，用于快速填充挂号信息
    @RequestMapping("/getPatient")
    @ResponseBody
    public Map<String, Object> getPatient(@RequestParam("medicalNo") int medicalNo){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("patient", registrationService.getPatient(medicalNo));
        return map;
    }

    // 根据病历号，查找对应的患者信息，以及在该病例号下的所有挂号信息
    @RequestMapping(value = "/getRegistrationInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRegistrationInfo(@RequestParam("medicalNo") int medicalNo){
        Patient patient = registrationService.getPatient(medicalNo);
        if (patient == null)
            patient = new Patient();
        Map<String, Object> model = registrationService.getRegistration(medicalNo);
        model.put("name", patient.getName());
        model.put("idNumber", patient.getIdNumber());
        model.put("address", patient.getAddress());
        return model;
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> withdrawRegistration(@RequestParam("regId") int regId){
        return registrationService.withdrawRegistration(regId);
    }
}
