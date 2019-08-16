package com.springMvc.entity.po;

public class HomePage {
    private Integer caseId;

    private String chiefComplaint;

    private String presentIll;

    private String treatmentPresIll;

    private String previousIll;

    private String allergy;

    private String healthCheckup;

    private String checkType;

    private String checkAdvice;

    private String note;

    private Boolean committed;

    private Boolean deleted;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getPresentIll() {
        return presentIll;
    }

    public void setPresentIll(String presentIll) {
        this.presentIll = presentIll;
    }

    public String getTreatmentPresIll() {
        return treatmentPresIll;
    }

    public void setTreatmentPresIll(String treatmentPresIll) {
        this.treatmentPresIll = treatmentPresIll;
    }

    public String getPreviousIll() {
        return previousIll;
    }

    public void setPreviousIll(String previousIll) {
        this.previousIll = previousIll;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getHealthCheckup() {
        return healthCheckup;
    }

    public void setHealthCheckup(String healthCheckup) {
        this.healthCheckup = healthCheckup;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckAdvice() {
        return checkAdvice;
    }

    public void setCheckAdvice(String checkAdvice) {
        this.checkAdvice = checkAdvice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getCommitted() {
        return committed;
    }

    public void setCommitted(Boolean committed) {
        this.committed = committed;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}