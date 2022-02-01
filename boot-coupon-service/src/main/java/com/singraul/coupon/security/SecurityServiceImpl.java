package com.singraul.coupon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.singraul.coupon.service.UserDetailServiceImpl;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailServiceImpl  userDetailService;
	
	@Autowired
	AuthenticationManager  authenticationManager ;
	
	@Override
	public boolean login(String userName, String password) {
		
		UserDetails	userDetails = userDetailService.loadUserByUsername(userName);
		
		UsernamePasswordAuthenticationToken  authToken=new UsernamePasswordAuthenticationToken(userDetails , 
				password,userDetails.getAuthorities()); 
		
		authenticationManager.authenticate(authToken) ;
		
		boolean result = authToken.isAuthenticated();
		
		if(result) {
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}
		
		return result;
	}

}
