package com.springMvc.controller;

import com.springMvc.dao.DiseaseMapper;
import com.springMvc.entity.vo.MedicalRecord;
import com.springMvc.entity.vo.PrescriptionDrugs;
import com.springMvc.service.DrugService;
import com.springMvc.service.HomePageService;
import com.springMvc.service.PrescriptionService;
import com.springMvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OutpatientDoctor {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private DiseaseMapper diseaseMapper;

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private PrescriptionService prescriptionService;

    // 获取医生对应的未就诊和已诊断的病人
    @RequestMapping("/getPatientForDoctor")
    @ResponseBody
    public Map<String, Object> getPatientForDoctor(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        int odId = (int) session.getAttribute("userId");
        return registrationService.getPatientForDoctor(odId);
    }


    // 根据医生输入的信息，对疾病名称进行模糊查询
    @RequestMapping(value = "/getDiseaseInfo", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getDiseaseInfo(@RequestParam("term") String keyword){
        return diseaseMapper.selectByKeyword(keyword);
    }

    // 根据病历首页的信息，完成医生的看诊功能
    @RequestMapping(value = "/see", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> see(@RequestBody MedicalRecord medicalRecord){
        homePageService.see(medicalRecord);
        Map<String, Object> rs = new HashMap<>();
        rs.put("success", medicalRecord.getSuccess());
        return rs;
    }

    // 根据关键字，模糊查询药品信息
    @RequestMapping(value = "/getDrugs", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getDrugs(@RequestParam("term") String keyword){
        return drugService.getDrugs(keyword);
    }

    // 处方开立
    @RequestMapping(value = "/prescribeDrugs", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDrugs(@RequestBody PrescriptionDrugs prescriptionDrugs){
        prescriptionService.prescribeDrugs(prescriptionDrugs);
        Map<String, Object> rs = new HashMap<>();
        rs.put("success", prescriptionDrugs.getSuccess());
        rs.put("presId", prescriptionDrugs.getPresId());
        return rs;
    }

    // 结束就诊，将病人挂号的状态改为已诊断
    @RequestMapping(value="/endDiagnose", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> endDiagnose(@RequestParam("regId") Integer regId){
        boolean success = registrationService.endDiagnose(regId);
        Map<String, Object> map = new HashMap<>(5);
        map.put("success", success);
        map.put("regId", regId);
        return map;
    }
}
