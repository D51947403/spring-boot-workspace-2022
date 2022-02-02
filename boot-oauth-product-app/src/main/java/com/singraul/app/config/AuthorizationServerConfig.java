package com.singraul.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.singraul.app.service.UserDetailsServcieImpl;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String OAUTH_SECRET = "9999";

	private static final String RESOURCE_ID = "product-rest-oauth";

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	DataSource dataSource;

	@Autowired
	UserDetailsServcieImpl userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder ;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(new JdbcTokenStore(dataSource)).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("product-rest-client").secret(passwordEncoder.encode(OAUTH_SECRET)).authorizedGrantTypes("password","refresh_token")
		.scopes("read","write").resourceIds(RESOURCE_ID);
	}
}
