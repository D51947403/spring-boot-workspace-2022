package com.singraul.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	private static final String RESOURCE_ID = "oauth-app-service";

	/*
	 * @Value("${publicKey}") private String publicKey;
	 */
	// text private key
	@Value("${testSignKey}")
	private String testSignKey;
	
	/*
	 * @Override public void configure(ResourceServerSecurityConfigurer resources)
	 * throws Exception {
	 * 
	 * resources.resourceId(RESOURCE_ID); }
	 */
	// using symmetric key 
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

		resources.resourceId(RESOURCE_ID).tokenStore(tokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/coupon-rest-api/coupon/{code:^[A-Z]*$}" ).hasAnyRole("ADMIN", "USER")
				.mvcMatchers(HttpMethod.POST, "/coupon-rest-api/coupon" ).hasRole("ADMIN")
				.anyRequest().denyAll().and().csrf().disable();
				
	}
	
// these method no longer in use while using dynamic public key
	/*
	 * @Bean public TokenStore tokenStore() { return new
	 * JwtTokenStore(jwtAccessTokenConverter()); }
	 * 
	 * @Bean public JwtAccessTokenConverter jwtAccessTokenConverter() {
	 * JwtAccessTokenConverter jwtAccessTokenConverter = new
	 * JwtAccessTokenConverter(); jwtAccessTokenConverter.setVerifierKey(publicKey);
	 * return jwtAccessTokenConverter; }
	 */
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		// using symmetric key or private key
		jwtAccessTokenConverter.setSigningKey(testSignKey);
		return jwtAccessTokenConverter;
	}
}
