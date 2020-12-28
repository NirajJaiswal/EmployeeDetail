package com.example.employeedetail.model;

import java.io.Serializable;
import java.util.List;

public class EmployeeResponse implements Serializable
{
  private List<EmployeeDetails> employeeDetails;

    public List<EmployeeDetails> getEmployeeDetails() {
        return employeeDetails;
    }
}
