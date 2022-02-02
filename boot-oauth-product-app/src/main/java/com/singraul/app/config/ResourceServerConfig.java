package com.singraul.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	private static final String RESOURCE_ID = "product-rest-oauth";
	
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		   http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/product-rest-api/product/{id:^[0-9]*$}").hasAnyRole("ADMIN","USER")
		   .mvcMatchers(HttpMethod.POST, "/product-rest-api/product").hasRole("ADMIN")
		   .anyRequest().denyAll().and().csrf().disable();
	}
}
