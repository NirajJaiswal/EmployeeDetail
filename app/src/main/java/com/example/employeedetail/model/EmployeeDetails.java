package com.example.employeedetail.model;

import java.io.Serializable;

public class EmployeeDetails implements Serializable {
    private String Name;
    private String Designation;
    private int Profile;
    private int age;


    public EmployeeDetails(String name, String designation, int profile, int age) {
        Name = name;
        Designation = designation;
        Profile = profile;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public String getDesignation() {
        return Designation;
    }

    public int getProfile() {
        return Profile;
    }

    public int getAge() {
        return age;
    }
}


