package com.singraul.coupon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.singraul.coupon.service.UserDetailServiceImpl;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailServiceImpl userDetailServ;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServ);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		// coupon code must be only ALPHABET --> Regular expression
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/coupon-rest-api/coupon/{code:^[A-Z]*$}" ,"/"
				,"/index" , "/createCoupon", "/getCoupon").hasAnyRole("ADMIN", "USER")
				.mvcMatchers(HttpMethod.POST, "/coupon-rest-api/coupon" ,"/saveCoupon").hasRole("ADMIN")
				.anyRequest().denyAll().and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
