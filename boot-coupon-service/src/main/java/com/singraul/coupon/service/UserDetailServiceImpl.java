package com.singraul.coupon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.singraul.coupon.model.User;
import com.singraul.coupon.repos.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		
		if(user==null) {
			throw new UsernameNotFoundException("User name not found for "+email);
		}
		return 	new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
		
		
	}

}
