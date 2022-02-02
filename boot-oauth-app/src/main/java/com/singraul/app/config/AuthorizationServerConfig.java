package com.singraul.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String RESOURCE_ID = "oauth-app-service";
	
	@Autowired
	private AuthenticationManager authenticationManager ;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	// for inMemory token Store
	/*
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) throws Exception {
	 * 
	 * endpoints.tokenStore(new
	 * InMemoryTokenStore()).authenticationManager(authenticationManager).
	 * userDetailsService(userDetailsService); }
	 */
	 
	// for database token Store
	 @Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		 endpoints.tokenStore(new JdbcTokenStore(dataSource)).authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}
	 
	 @Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("boot-oauth-app").secret(passwordEncoder.encode("9999"))
		.authorizedGrantTypes("password","refresh_token").scopes("read","write").resourceIds(RESOURCE_ID);
	}
}
