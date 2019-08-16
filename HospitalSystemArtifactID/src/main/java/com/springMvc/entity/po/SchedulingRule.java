package com.springMvc.entity.po;

import java.util.Date;

public class SchedulingRule {
    private Integer shedId;

    private String name;

    private String rule;

    private Date createTime;

    private Integer odId;

    private Boolean deleted;

    public Integer getShedId() {
        return shedId;
    }

    public void setShedId(Integer shedId) {
        this.shedId = shedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}