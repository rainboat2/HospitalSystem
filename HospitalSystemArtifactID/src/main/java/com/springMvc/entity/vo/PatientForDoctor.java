package com.springMvc.entity.vo;

public class PatientForDoctor {

    private int medicalNo;
    private int regId;
    private String name;
    private int age;

    public int getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(int medicalNo) {
        this.medicalNo = medicalNo;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
