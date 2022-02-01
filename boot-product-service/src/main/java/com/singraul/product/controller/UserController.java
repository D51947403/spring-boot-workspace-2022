package com.singraul.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.singraul.product.model.User;
import com.singraul.product.repos.UserRepository;
import com.singraul.product.security.SecurityService;

@Controller
public class UserController {

	@Autowired
	SecurityService securityService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder passEncoder;

	@GetMapping("/")
	public String showLogin() {
		return "login";
	}

	@GetMapping("/index")
	public String showIndex() {
		return "index";
	}

	@PostMapping("/login")
	public String login(String email, String password) {
		boolean result = securityService.login(email, password);

		if (result) {
			return "index";
		}

		return "login";
	}

	@GetMapping("/showReg")
	public String showReg() {
		return "registerUser";
	}

	@PostMapping("/registerUser")
	public String registerUser(User user) {

		String rawPassword = user.getPassword();
		user.setPassword(passEncoder.encode(rawPassword));
		User savedUser= userRepo.save(user);
		
		if(savedUser.getId() > 0) {
			return "login";
		}

		return "registerUser";
	}
}
