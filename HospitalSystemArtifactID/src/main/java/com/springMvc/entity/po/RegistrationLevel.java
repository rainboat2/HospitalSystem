package com.springMvc.entity.po;

import java.math.BigDecimal;

public class RegistrationLevel {
    private String reglCode;

    private String name;

    private Integer limitation;

    private Integer sequenceNo;

    private BigDecimal fee;

    private Boolean deleted;

    public String getReglCode() {
        return reglCode;
    }

    public void setReglCode(String reglCode) {
        this.reglCode = reglCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
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