package com.singraul.cloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.cloud.client.UserClientService;
import com.singraul.cloud.dto.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class BootSpringcloudFeignApplication {

	@Autowired
	UserClientService  userClient;
	
	@GetMapping("/findAllUser")
	public List<UserResponse> findAllUser(){
		
	return 	userClient.findAllUser();
	
	}
	
	@GetMapping("/findComments")
	public List<UserResponse> findComments(){
		
		return 	userClient.findComments();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootSpringcloudFeignApplication.class, args);
	}

}
