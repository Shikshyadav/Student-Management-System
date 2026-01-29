package com.shi.studentmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shi.studentmanagement.model.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {

    boolean existsByUsername(String username);

    Optional<Users> findByUsername(String username);
}
