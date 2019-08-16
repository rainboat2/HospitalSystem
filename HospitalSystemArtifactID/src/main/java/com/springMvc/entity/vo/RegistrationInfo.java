package com.springMvc.entity.vo;

import java.util.Date;

/**
 * 本类用于接受前端传来的挂号信息
 */
public class RegistrationInfo {

    private String patName;

    private String patId;

    private Boolean gender;

    private Date birthday;

    private String address;

    private Boolean printed;

    private Integer odId;

    private Integer deptId;

    private String reglCode;

    private String type;

    private Integer medicalNo;

    private Integer regId;

    private Boolean success;

    private Integer cId;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(Integer medicalNo) {
        this.medicalNo = medicalNo;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getPrinted() {
        return printed;
    }

    public void setPrinted(Boolean printed) {
        this.printed = printed;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getReglCode() {
        return reglCode;
    }

    public void setReglCode(String reglCode) {
        this.reglCode = reglCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
