package com.singraul.boot.restapi.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootRestapiProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestapiProductApplication.class, args);
	}

}
