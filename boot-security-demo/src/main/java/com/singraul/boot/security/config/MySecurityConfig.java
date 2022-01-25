package com.singraul.boot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationProvider  authenticationProvider;
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 * InMemoryUserDetailsManager userServiceDetail = new
	 * InMemoryUserDetailsManager(); UserDetails userDetail =
	 * User.withUsername("devendra").password(passwordEncoder.encode("kumar"))
	 * .authorities("read").build(); userServiceDetail.createUser(userDetail);
	 * 
	 * auth.userDetailsService(userServiceDetail).passwordEncoder(passwordEncoder);
	 * 
	 * }
	 */

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authenticationProvider);

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();

	}

}
