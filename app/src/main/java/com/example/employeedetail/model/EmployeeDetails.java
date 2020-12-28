package com.example.employeedetail.model;

import java.io.Serializable;

public class EmployeeDetails implements Serializable {
    private String name;
    private String designation;
    private int age;


    public EmployeeDetails(String name, String designation, int age) {
        this.name = name;
        this.designation = designation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "Name='" + name + '\'' +
                ", Designation='" + designation + '\'' +
                ", age=" + age +
                '}';
    }
}


