package com.boot.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	// Use of Spring Expression Language 
	@Value(value = "#{'${spring.project.names}'.split(',')}")
	private List<String> springProjectList ;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot Application";
	}
	
	
	@GetMapping("/getSpringProjectNames")
	public List<String> getSpringProjectNames() {
		System.out.println(springProjectList.toString());
		return springProjectList;
	}
}
