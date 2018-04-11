package com.sft.management.ServiceImpl;

import com.sft.management.Models.Employees;
import com.sft.management.Models.Managers;
import com.sft.management.Repos.EmployeeRepo;
import com.sft.management.Repos.ManagerRepo;
import com.sft.management.Services.ManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ManagementServiceImpl implements ManagementServiceI {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ManagerRepo managerRepo;


    @Override
    public List<Employees> findAllEmployees() {

        List<Employees> employees = new ArrayList<Employees>();
        for(Employees employee: employeeRepo.findAll())
        {
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public List<Managers> findAllManagers() {

        List<Managers> managers = new ArrayList<Managers>();
        for(Managers manager: managerRepo.findAll())
        {
            managers.add(manager);
        }
        return managers;
    }

    @Override
    public void saveManagers(Managers manager) {

        managerRepo.save(manager);
    }

    @Override
    public void deleteManagers(Long id) {

        managerRepo.deleteById(id);
    }
}
