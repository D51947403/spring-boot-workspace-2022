package com.singraul.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.singraul.security.service.UserDetailsServcieImpl;

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

	@Value("${jskKeyFile}")
	private String jskKeyFile;
	@Value("${jskPassword}")
	private String jskPassword;
	@Value("${jskAlias}")
	private String jskAlias;
	
	// text private key
	@Value("${testSignKey}")
	private String testSignKey;
	
	// for jwt token store

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("product-rest-client").secret(passwordEncoder.encode(OAUTH_SECRET)).authorizedGrantTypes("password","refresh_token")
		.scopes("read","write").resourceIds(RESOURCE_ID);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// any body can access public key
		security.tokenKeyAccess("permitAll()");
	}
	
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
