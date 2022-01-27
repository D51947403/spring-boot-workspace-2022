package com.singraul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer

/*
 * url to test project http://localhost:8888/config-server-client/development
 * http://localhost:8888/config-server-client/production
 * http://localhost:8888/config-server-client/default
 */
public class BootCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCloudConfigServerApplication.class, args);
	}

}
