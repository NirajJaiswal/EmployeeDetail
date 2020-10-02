package com.example.employeedetail.model;

public class EmployeeDetails {
    private String Name;
    private String Designation;
    private int Profile;

    public EmployeeDetails(String Name, String Designation, int Profile) {
        this.Name = Name;
        this.Designation = Designation;
        this.Profile = Profile;
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
}


