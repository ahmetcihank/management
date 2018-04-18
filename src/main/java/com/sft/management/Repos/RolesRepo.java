package com.sft.management.Repos;

import com.sft.management.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository<Role, Long> {
}
