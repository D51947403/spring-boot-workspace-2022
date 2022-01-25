package com.singraul.boot.security;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class BootSecurityDemoApplicationTests {

	@Test
	void testPasswordEncoder() {
		System.out.println(new BCryptPasswordEncoder().encode("kumar"));
		System.out.println(new Pbkdf2PasswordEncoder().encode("kumar"));
		// this encoder requires BouncyCastle dependency 
		System.out.println(new SCryptPasswordEncoder().encode("kumar"));
		
		Map<String,PasswordEncoder>  encoderMap=new HashMap<>();
		
		encoderMap.put("bcrypt", new BCryptPasswordEncoder());
		encoderMap.put("scrypt", new SCryptPasswordEncoder());
		
		System.out.println(new DelegatingPasswordEncoder("bcrypt",encoderMap ).encode("kumar"));
		
	}

}
