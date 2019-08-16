package com.springMvc.entity.po;

import java.math.BigDecimal;

public class PrescriptionDetailPayment {
    private Integer presPayId;

    private Integer presDetailId;

    private Integer cId;

    private BigDecimal fee;

    private Boolean deleted;

    public Integer getPresPayId() {
        return presPayId;
    }

    public void setPresPayId(Integer presPayId) {
        this.presPayId = presPayId;
    }

    public Integer getPresDetailId() {
        return presDetailId;
    }

    public void setPresDetailId(Integer presDetailId) {
        this.presDetailId = presDetailId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
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