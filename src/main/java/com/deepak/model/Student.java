package com.deepak.model;

public class Student {
    private String rollNo;
    private String name;
    private String email;
    private String phoneNo;
    private int departmentId;

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name Cannot Be Empty");
        }
        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {

        this.phoneNo = phoneNo;
    }

    public void setDepartmentId(int departmentId) {
        if(departmentId <= 0){
            throw new IllegalArgumentException("Department ID must be positive");
        }
        this.departmentId = departmentId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Student(String rollNo, String name, String email, String phoneNo, int departmentId) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.departmentId = departmentId;
    }
}
