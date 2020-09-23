package com.example.employeedetail;

import java.io.Serializable;

public class Employee implements Serializable {
    private String empName;
    private int empId;
    private String empPost;
    private String empRev;

    public Employee(String empName, int empId, String empPost, String empRev) {
        this.empName = empName;
        this.empId = empId;
        this.empPost = empPost;
        this.empRev = empRev;
    }

    public String getEmpPost() {
        return empPost;
    }

    public void setEmpPost(String empPost) {
        this.empPost = empPost;
    }

    public String getEmpRev() {
        return empRev;
    }

    public void setEmpRev(String empRev) {
        this.empRev = empRev;
    }



    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}

