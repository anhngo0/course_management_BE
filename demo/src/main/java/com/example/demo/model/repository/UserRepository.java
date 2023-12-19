package com.example.demo.model.repository;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT s FROM User s WHERE s.role = ?1")
    User findByRole(UserRole userRole);
}
