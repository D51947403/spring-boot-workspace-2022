package com.singraul.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.security.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
