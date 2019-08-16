package com.springMvc.entity.po;

import java.util.Date;

public class PrescriptionTemplate {
    private String presTempName;

    private Date createTime;

    private String scope;

    private String type;

    private Integer createId;

    private Boolean deleted;

    public String getPresTempName() {
        return presTempName;
    }

    public void setPresTempName(String presTempName) {
        this.presTempName = presTempName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}