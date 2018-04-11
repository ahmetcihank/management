package com.sft.management.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employees
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_no")
    private long Id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name="employee_title")
    private String employeeTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_no")
    @JsonIgnore
    private Managers manager;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public Managers getManager() {
        return manager;
    }

    public void setManager(Managers manager) {
        this.manager = manager;
    }

    public Employees() {
    }

    public Employees(String employeeName, String employeeTitle, Managers manager) {
        this.employeeName = employeeName;
        this.employeeTitle = employeeTitle;
        this.manager = manager;
    }
}
