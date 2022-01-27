package com.singraul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * url to test project http://localhost:8888/config-server-client/development
 * http://localhost:8888/config-server-client/production
 * http://localhost:8888/config-server-client/default
 */
@SpringBootApplication
public class BootCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCloudConfigClientApplication.class, args);
	}

}
