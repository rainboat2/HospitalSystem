package com.springMvc.entity.po;

public class MedicalDoctor {
    private Integer mdId;

    private String password;

    private String name;

    private String title;

    private Integer deptId;

    private Boolean inScheduling;

    private Boolean deleted;

    public Integer getMdId() {
        return mdId;
    }

    public void setMdId(Integer mdId) {
        this.mdId = mdId;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}