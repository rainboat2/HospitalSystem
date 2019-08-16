package com.springMvc.entity.po;

public class OutpatientDoctor {
    private Integer odId;

    private String password;

    private String name;

    private String title;

    private Integer deptId;

    private Boolean inScheduling;

    private String reglCode;

    private Boolean deleted;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Boolean getInScheduling() {
        return inScheduling;
    }

    public void setInScheduling(Boolean inScheduling) {
        this.inScheduling = inScheduling;
    }

    public String getReglCode() {
        return reglCode;
    }

    public void setReglCode(String reglCode) {
        this.reglCode = reglCode;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}