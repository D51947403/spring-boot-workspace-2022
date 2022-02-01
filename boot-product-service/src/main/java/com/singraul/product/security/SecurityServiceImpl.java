package com.singraul.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.singraul.product.service.UserDetailsServiceImpl;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsServiceImpl  userDetailService;
	
	@Autowired
	AuthenticationManager authenticationManager ;
	
	@Override
	public boolean login(String email, String password) {
		
		UserDetails  userDetail =userDetailService.loadUserByUsername(email);
		
		UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetail ,password ,
				userDetail.getAuthorities());
		
		authenticationManager.authenticate(authToken);
		
		boolean result= authToken.isAuthenticated();
		
		if(result) {
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}
		
		return result;
	}

}
