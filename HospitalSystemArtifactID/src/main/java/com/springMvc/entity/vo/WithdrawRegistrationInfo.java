package com.springMvc.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

// 用来存放退号时所需的挂号信息
public class WithdrawRegistrationInfo {

    private Integer regId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp regTime;
    private String deptName;
    private String regState;

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }
}
