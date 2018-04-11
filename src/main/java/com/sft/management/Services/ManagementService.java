package com.sft.management.Services;

import com.sft.management.Models.Book;
import com.sft.management.Models.Employees;
import com.sft.management.Models.Managers;
import com.sft.management.Repos.EmployeeRepo;
import com.sft.management.Repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementService
{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ManagerRepo managerRepo;

    public List<Employees> findAllEmployees(){
        List<Employees> employees = new ArrayList<Employees>();
        for(Employees employee: employeeRepo.findAll())
        {
            employees.add(employee);
        }
        return employees;
    }


    public List<Managers> findAllManagers(){
        List<Managers> managers = new ArrayList<Managers>();
        for(Managers manager: managerRepo.findAll())
        {
            managers.add(manager);
        }
        return managers;
    }

    public void saveManagers(Managers manager)
    {
        managerRepo.save(manager);
    }

    public void deleteManagers(Long id){
        managerRepo.deleteById(id);
    }
}
