package com.springMvc.entity.vo;

public class MedicalRecord {

    private Integer regId;
    private String type;
    private String chiefComplaint;
    private String presentIll;
    private String treatmentPresIll;
    private String previousIll;
    private String allergy;
    private String healthCheckup;
    private String note;
    private String diagnoses;
    private Boolean committed;
    private Boolean success;

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getCommitted() {
        return committed;
    }

    public void setCommitted(Boolean committed) {
        this.committed = committed;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }
}
