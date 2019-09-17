package com.springMvc.controller;

import com.springMvc.dao.DiseaseMapper;
import com.springMvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class OutpatientDoctor {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private DiseaseMapper diseaseMapper;

    // 获取医生对应的未就诊和已诊断的病人
    @RequestMapping("/getPatientForDoctor")
    @ResponseBody
    public Map<String, Object> getPatientForDoctor(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        int odId = (int) session.getAttribute("userId");
        return registrationService.getPatientForDoctor(odId);
    }


    @RequestMapping(value = "/getDiseaseInfo", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getDiseaseInfo(@RequestParam("term") String keyword){
        List<Map<String, Object>> infos = diseaseMapper.selectByKeyword(keyword);
        List<String> rs = new ArrayList<>(infos.size());
        for (Map<String, Object> item : infos)
            rs.add(item.get("name") + "-" + item.get("icd"));
        return infos;
    }
}
