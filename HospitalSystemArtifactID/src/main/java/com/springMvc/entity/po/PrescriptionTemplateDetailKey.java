package com.springMvc.entity.po;

public class PrescriptionTemplateDetailKey {
    private String presTempName;

    private Integer drugId;

    public String getPresTempName() {
        return presTempName;
    }

    public void setPresTempName(String presTempName) {
        this.presTempName = presTempName;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }
}