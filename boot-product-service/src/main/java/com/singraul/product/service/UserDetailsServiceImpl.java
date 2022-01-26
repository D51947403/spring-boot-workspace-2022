package com.singraul.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.singraul.product.model.User;
import com.singraul.product.repos.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);     
		if(user ==null) {
			throw new UsernameNotFoundException("User name not found for "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword() , user.getRoles());
	}

}
