package com.singraul.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.singraul.coupon.model.User;
import com.singraul.coupon.repos.UserRepo;
import com.singraul.coupon.security.SecurityService;

@Controller
public class UserController {

	@Autowired
	SecurityService securityService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder  passwordEncoder;

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
	
	@GetMapping("/showReg")
	public String showReg() {
		return "registerUser";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(User user) {
		String encodePassword= passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		userRepo.save(user);
			return "login";

	}
}
