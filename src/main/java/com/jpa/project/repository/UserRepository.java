package com.jpa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.project.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
