package com.example.user_manegement_system.repository;

import com.example.user_manegement_system.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}