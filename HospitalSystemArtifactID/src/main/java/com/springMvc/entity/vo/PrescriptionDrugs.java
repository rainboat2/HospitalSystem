package com.springMvc.entity.vo;

public class PrescriptionDrugs {

    private Integer regId;
    private String presName;
    private String type;
    private String presList;
    private Integer len;
    private Integer presId;
    private Boolean success;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getPresName() {
        return presName;
    }

    public void setPresName(String presName) {
        this.presName = presName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPresList() {
        return presList;
    }

    public void setPresList(String presList) {
        this.presList = presList;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getPresId() {
        return presId;
    }

    public void setPresId(Integer presId) {
        this.presId = presId;
    }
}
