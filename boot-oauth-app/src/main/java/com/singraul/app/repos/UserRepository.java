package com.singraul.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
