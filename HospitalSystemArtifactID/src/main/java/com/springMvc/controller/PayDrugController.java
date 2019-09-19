package com.springMvc.controller;

import com.springMvc.entity.po.Patient;
import com.springMvc.service.PatientService;
import com.springMvc.service.PrescriptionDetailService;
import com.springMvc.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PayDrugController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PrescriptionDetailService prescriptionDetailService;

    // 根据病历号，获取所有的状态为已开立的药方
    @RequestMapping(value = "/getPrescriptionDrugs", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDrugs(@RequestParam("medicalNo") Integer medicalNo, @RequestParam("state") String state){
        Patient patient = patientService.getPatient(medicalNo);
        Map<String, Object> rs = new HashMap<>();
        rs.put("medicalNo", medicalNo);
        rs.put("state", state);

        List<Map<String, Object>> drugs = prescriptionService.getDrugsForPay(rs);
        rs.put("name", patient.getName());
        rs.put("idNumber", patient.getIdNumber());
        rs.put("address", patient.getAddress());
        rs.put("drugs", drugs);
        return rs;
    }

    @RequestMapping(value = "/payFee", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDrugs(@RequestParam("presDetailIds") String presDetailId, @RequestParam("state") String state){
        Map<String, Object> rs = new HashMap<>();
        if (!presDetailId.equals("")){
            String[] ids = presDetailId.split("-");
            List<Integer> presIds = new ArrayList<>(ids.length);
            for (String id : ids)
                presIds.add(Integer.parseInt(id));
            boolean flag = prescriptionDetailService.changeState(presIds, state);
            rs.put("success", flag);
        }
        rs.put("success", true);
        return rs;
    }
}
