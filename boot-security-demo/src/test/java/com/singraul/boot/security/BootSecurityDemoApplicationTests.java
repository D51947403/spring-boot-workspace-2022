package com.singraul.boot.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	}

}
