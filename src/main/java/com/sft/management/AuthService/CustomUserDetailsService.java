package com.sft.management.AuthService;

import com.sft.management.Models.CustomUserDetails;
import com.sft.management.Models.Users;
import com.sft.management.Repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepo.findByUsername(userName);



        optionalUsers.orElseThrow(()-> new UsernameNotFoundException("user not found"));



        return optionalUsers.map(users -> {return new CustomUserDetails(users);}).get();
    }
}
