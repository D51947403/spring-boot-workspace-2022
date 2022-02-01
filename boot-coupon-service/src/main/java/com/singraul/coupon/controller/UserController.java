package com.singraul.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.singraul.coupon.security.SecurityService;

@Controller
public class UserController {

	@Autowired
	SecurityService securityService;

	@GetMapping("/")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password) {
		boolean result = securityService.login(email, password);
		if (result)
			return "index";
		else
			return "login";

	}
}
