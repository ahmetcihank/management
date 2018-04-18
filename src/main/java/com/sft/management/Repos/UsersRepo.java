package com.sft.management.Repos;


import com.sft.management.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String s);
}
