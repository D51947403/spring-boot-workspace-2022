package com.singraul.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.cloud.client.UserClientService;
import com.singraul.cloud.dto.UserResponse;

@RestController

public class UserRestController {

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
}
