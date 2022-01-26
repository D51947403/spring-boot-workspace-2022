package com.singraul.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.coupon.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
