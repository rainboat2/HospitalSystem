package com.springMvc.entity.po;

import java.util.Date;

public class SchedulingPlanKey {
    private Integer odId;

    private Date scheDate;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Date getScheDate() {
        return scheDate;
    }

    public void setScheDate(Date scheDate) {
        this.scheDate = scheDate;
    }
}