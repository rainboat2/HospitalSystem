package com.springMvc.entity.po;

public class Disease {
    private Integer diseId;

    private String code;

    private String name;

    private String icd;

    private Integer diseCateId;

    private Boolean deleted;

    public Integer getDiseId() {
        return diseId;
    }

    public void setDiseId(Integer diseId) {
        this.diseId = diseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcd() {
        return icd;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public Integer getDiseCateId() {
        return diseCateId;
    }

    public void setDiseCateId(Integer diseCateId) {
        this.diseCateId = diseCateId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}