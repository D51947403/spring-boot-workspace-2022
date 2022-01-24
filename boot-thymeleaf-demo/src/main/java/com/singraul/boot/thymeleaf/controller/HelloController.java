package com.singraul.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/sendData", method = RequestMethod.GET)
	public ModelAndView sendData() {

		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Take up one idea and make your life easy.");
		return mav;

	}
}
