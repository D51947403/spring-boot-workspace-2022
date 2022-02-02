package com.singraul.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.singraul.product.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsServiceImpl userDetailsService ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   //http.httpBasic();
	   http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/product-rest-api/product").hasAnyRole("ADMIN","USER")
	   .mvcMatchers(HttpMethod.POST, "/product-rest-api/product").hasRole("ADMIN")
	   .mvcMatchers(HttpMethod.GET, "/index").hasAnyRole("ADMIN","USER")
	   .mvcMatchers(HttpMethod.GET, "/","/showReg").permitAll()
	   .mvcMatchers(HttpMethod.POST , "/login","/registerUser").permitAll()
	   .anyRequest().denyAll().and().csrf().disable().logout().logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder passswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}