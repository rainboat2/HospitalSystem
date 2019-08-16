package com.springMvc.entity.po;

public class TechnicianApplicationDetail {
    private Integer applDetailId;

    private Integer caseId;

    private String applName;

    private Integer nonMid;

    private String checkResult;

    private String state;

    private Boolean deleted;

    public Integer getApplDetailId() {
        return applDetailId;
    }

    public void setApplDetailId(Integer applDetailId) {
        this.applDetailId = applDetailId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getApplName() {
        return applName;
    }

    public void setApplName(String applName) {
        this.applName = applName;
    }

    public Integer getNonMid() {
        return nonMid;
    }

    public void setNonMid(Integer nonMid) {
        this.nonMid = nonMid;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}