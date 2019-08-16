package com.springMvc.entity.vo;

/**
 * 挂号的时候，显示在页面上的医生信息
 */
public class RegistrationDoctor {

    private Integer odId;
    private String name;
    private String reglLevel;
    private String reglCode;
    private String deptName;
    private int patNumber;
    private int limitation;

    public int getLimitation() {
        return limitation;
    }

    public void setLimitation(int limitation) {
        this.limitation = limitation;
    }

    public String getReglCode() {
        return reglCode;
    }

    public void setReglCode(String reglCode) {
        this.reglCode = reglCode;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReglLevel() {
        return reglLevel;
    }

    public void setReglLevel(String reglLevel) {
        this.reglLevel = reglLevel;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getPatNumber() {
        return patNumber;
    }

    public void setPatNumber(int patNumber) {
        this.patNumber = patNumber;
    }
}
