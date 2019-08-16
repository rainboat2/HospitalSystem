package com.springMvc.entity.po;

import java.math.BigDecimal;

public class TechnicianApplicationDetailPayment {
    private Integer applPayId;

    private Integer cId;

    private Integer applDetailId;

    private BigDecimal fee;

    private Boolean deleted;

    public Integer getApplPayId() {
        return applPayId;
    }

    public void setApplPayId(Integer applPayId) {
        this.applPayId = applPayId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getApplDetailId() {
        return applDetailId;
    }

    public void setApplDetailId(Integer applDetailId) {
        this.applDetailId = applDetailId;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}