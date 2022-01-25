package com.singraul.boot.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
   
	@RequestMapping(value="/city", method=RequestMethod.GET)
	public String getCity() {
		return "Welcome to Satna city";
	}
	
	
	@RequestMapping(value="/zipcode", method=RequestMethod.GET)
	public String getZipCode() {
		return "Satna zipcode is : 485001";
	}
	
}
