package com.company;

public class Employee {
    private String name;
    private EmployeeType employeeType;

    public Employee(String name, EmployeeType employeeType) {
        this.name = name;
        this.employeeType = employeeType;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
}
