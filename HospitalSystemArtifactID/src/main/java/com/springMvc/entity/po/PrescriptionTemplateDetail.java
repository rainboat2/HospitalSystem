package com.springMvc.entity.po;

public class PrescriptionTemplateDetail extends PrescriptionTemplateDetailKey {
    private Integer amount;

    private String dosage;

    private String frequency;

    private String numberPer;

    private String drugUsage;

    private Boolean deleted;

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}