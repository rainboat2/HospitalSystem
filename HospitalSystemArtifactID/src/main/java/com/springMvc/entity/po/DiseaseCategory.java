package com.springMvc.entity.po;

public class DiseaseCategory {
    private Integer diseCateId;

    private String cateCode;

    private String cateName;

    private Integer sequenceNo;

    private Integer distType;

    private Boolean deleted;

    public Integer getDiseCateId() {
        return diseCateId;
    }

    public void setDiseCateId(Integer diseCateId) {
        this.diseCateId = diseCateId;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Integer getDistType() {
        return distType;
    }

    public void setDistType(Integer distType) {
        this.distType = distType;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}