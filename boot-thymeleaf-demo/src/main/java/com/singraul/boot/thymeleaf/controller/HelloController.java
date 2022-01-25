package com.singraul.boot.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		Student student = new Student();
		student.setName("Devendra");
		student.setScore(86);
		mav.addObject("studentObj", student);
		return mav;
	}

	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public ModelAndView getStudentList() {

		ModelAndView mav = new ModelAndView("studentList");

		Student student = new Student();
		student.setName("Devendra");
		student.setScore(86);

		Student student2 = new Student();
		student2.setName("Rahul");
		student2.setScore(96);

		Student student3 = new Student();
		student3.setName("Ragni");
		student3.setScore(76);

		Student student4 = new Student();
		student4.setName("Ranjana");
		student4.setScore(80);

		List<Student> studentList = Arrays.asList(student, student2, student3, student4);

		mav.addObject("studentList", studentList);

		return mav;
	}

	@RequestMapping(value = "/studentForm", method = RequestMethod.GET)
	public ModelAndView openStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student student = new Student();
		student.setName("Devendra");
		student.setScore(86);
		mav.addObject("studentForm", student);
		return mav;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student saveStudent) {
		ModelAndView mav = new ModelAndView("saveStudent");
		mav.addObject("saveStudent", saveStudent);
		return mav;
	}

}
