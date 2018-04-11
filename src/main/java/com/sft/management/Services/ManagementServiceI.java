package com.sft.management.Services;

import com.sft.management.Models.Employees;
import com.sft.management.Models.Managers;
import com.sft.management.Repos.EmployeeRepo;
import com.sft.management.Repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface ManagementServiceI
{

    public List<Employees> findAllEmployees();

    public List<Managers> findAllManagers();

    public void saveManagers(Managers manager);

    public void deleteManagers(Long id);
}
