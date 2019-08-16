package com.springMvc.entity.po;

public class MedicalTechnicianApplication extends MedicalTechnicianApplicationKey {
    private String applType;

    private String applState;

    private Integer medicalNo;

    private Integer deptId;

    private Boolean deleted;

    public String getApplType() {
        return applType;
    }

    public void setApplType(String applType) {
        this.applType = applType;
    }

    public String getApplState() {
        return applState;
    }

    public void setApplState(String applState) {
        this.applState = applState;
    }

    public Integer getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(Integer medicalNo) {
        this.medicalNo = medicalNo;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}