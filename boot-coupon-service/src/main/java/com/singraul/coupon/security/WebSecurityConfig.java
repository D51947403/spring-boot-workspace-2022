package com.singraul.coupon.security;

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
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

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
		// for custom login form this is not required
		//http.formLogin();
		// coupon code must be only ALPHABET --> Regular expression
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/coupon-rest-api/coupon/{code:^[A-Z]*$}",
				"/index" ,"/createCoupon")
		        //.hasAnyRole("ADMIN", "USER")
		        .permitAll()
				.mvcMatchers(HttpMethod.POST, "/coupon-rest-api/coupon" , "/saveCoupon").hasRole("ADMIN")
				.mvcMatchers("/login" ,"/" ,"/registerUser","/getCoupon","/showReg").permitAll()
				.anyRequest().denyAll().and()
				.logout().logoutSuccessUrl("/");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
