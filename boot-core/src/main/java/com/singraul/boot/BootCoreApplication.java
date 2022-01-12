package com.singraul.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootCoreApplication {

	public static void main(String[] args) {
		System.out.println("Spring boot core example ");
		SpringApplication.run(BootCoreApplication.class, args);
	}

}
