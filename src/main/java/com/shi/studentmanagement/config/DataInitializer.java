package com.shi.studentmanagement.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shi.studentmanagement.model.Users;
import com.shi.studentmanagement.repo.UsersRepo;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadSampleData(UsersRepo usersRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            if(!usersRepo.existsByUsername("Admin")){
            // Insert sample data on startup
            Users users = new Users();
            users.setUsername("Admin");
            users.setPassword(passwordEncoder.encode("admin123"));
            users.setActive(true);

            usersRepo.save(users);

            System.out.println("Sample user created!");
            }
        };
    }
}
