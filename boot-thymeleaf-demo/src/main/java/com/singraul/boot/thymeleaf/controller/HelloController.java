package com.singraul.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.singraul.boot.thymeleaf.model.Student;

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
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student= new Student();
		student.setName("Devendra");
		student.setScore(86);
		mav.addObject("studentObj", student);
		return mav;
	}
}
