package com.sft.management.Models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="managers")
public class Managers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_no")
    private long Id;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name="manager_title")
    private String managerTitle;

    @OneToMany(mappedBy="manager",fetch = FetchType.LAZY)
private List<Employees> employees;

    public Managers(){}


    public Managers(String managerName, String managerTitle, List<Employees> employees) {
        this.managerName = managerName;
        this.managerTitle = managerTitle;
        this.employees = employees;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerTitle() {
        return managerTitle;
    }

    public void setManagerTitle(String managerTitle) {
        this.managerTitle = managerTitle;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }
}
