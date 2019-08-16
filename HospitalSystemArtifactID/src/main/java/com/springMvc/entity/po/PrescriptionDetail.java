package com.springMvc.entity.po;

public class PrescriptionDetail {
    private Integer presDetailId;

    private Integer presId;

    private Integer drugId;

    private Integer amount;

    private String dosage;

    private String frequency;

    private String numberPer;

    private String drugUsage;

    private String state;

    private Boolean deleted;

    public Integer getPresDetailId() {
        return presDetailId;
    }

    public void setPresDetailId(Integer presDetailId) {
        this.presDetailId = presDetailId;
    }

    public Integer getPresId() {
        return presId;
    }

    public void setPresId(Integer presId) {
        this.presId = presId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNumberPer() {
        return numberPer;
    }

    public void setNumberPer(String numberPer) {
        this.numberPer = numberPer;
    }

    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
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