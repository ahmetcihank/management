package com.sft.management.Repos;

import com.sft.management.Models.Managers;
import org.apache.catalina.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepo extends CrudRepository<Managers, Long>
{

}
