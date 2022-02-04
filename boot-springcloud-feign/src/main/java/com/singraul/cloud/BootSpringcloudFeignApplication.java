package com.singraul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BootSpringcloudFeignApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BootSpringcloudFeignApplication.class, args);
	}

}
