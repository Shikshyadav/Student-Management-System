package com.shi.studentmanagement.service.impl;

import com.shi.studentmanagement.model.Users;
import com.shi.studentmanagement.repo.UsersRepo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UsersRepo usersRepo;

    // Correct constructor
    public UserServiceImpl(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid Username"));

        return User.withUsername(username)
                .password(users.getPassword())
                .disabled(!users.isActive())
                .build();
    }
}
