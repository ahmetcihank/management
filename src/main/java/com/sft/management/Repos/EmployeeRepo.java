package com.sft.management.Repos;

import com.sft.management.Models.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employees,Long> {
}
