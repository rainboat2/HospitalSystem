package com.springMvc.entity.po;

import java.util.Date;

public class Registration {
    private Integer regId;

    private Date regTime;

    private String reglCode;

    private String state;

    private Integer odId;

    private Integer medicalNo;

    private Boolean printRecord;

    private String settleType;

    private Integer cId;

    private Integer deptId;

    private Boolean deleted;

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getReglCode() {
        return reglCode;
    }

    public void setReglCode(String reglCode) {
        this.reglCode = reglCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(Integer medicalNo) {
        this.medicalNo = medicalNo;
    }

    public Boolean getPrintRecord() {
        return printRecord;
    }

    public void setPrintRecord(Boolean printRecord) {
        this.printRecord = printRecord;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}