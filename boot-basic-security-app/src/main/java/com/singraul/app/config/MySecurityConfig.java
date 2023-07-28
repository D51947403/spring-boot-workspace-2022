package com.singraul.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

//	@Bean 
//	UserDetailsService  userDetailService() {
//		InMemoryUserDetailsManager userDetailService=	new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("Devendra")
//				.password(passwordEncoder().encode("Devendra")).authorities("read").build();
//		userDetailService.createUser(user);
//		return userDetailService;
//	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 SecurityFilterChain filterChain(HttpSecurity http ) throws Exception{
		
	//	http.httpBasic();
		// form based login
		http.formLogin();
		http.authorizeHttpRequests().anyRequest().authenticated();
		return http.build();
		
	}
}
