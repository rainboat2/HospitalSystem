package com.springMvc.entity.po;

public class Prescription {
    private Integer presId;

    private Integer caseId;

    private String name;

    private String state;

    private String type;

    private Boolean deleted;

    private Integer deptId;

    private Integer medicalNo;

    public Integer getPresId() {
        return presId;
    }

    public void setPresId(Integer presId) {
        this.presId = presId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(Integer medicalNo) {
        this.medicalNo = medicalNo;
    }
}