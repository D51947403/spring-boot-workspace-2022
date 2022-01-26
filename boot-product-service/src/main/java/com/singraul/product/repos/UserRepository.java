package com.singraul.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.product.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
