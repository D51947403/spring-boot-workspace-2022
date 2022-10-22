package com.singraul.mockito.controller;
/**
 *  https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockito-junit-example/
 */
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.mockito.model.Employee;
import com.singraul.mockito.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	 @Autowired
	 EmployeeService employeeService ;
	 
	 @PostMapping("/save")
	 public Employee creatEmployee (@RequestBody Employee employee) {
		 return employeeService.save(employee);
	 }
	 
	 @GetMapping("/getAll")
	 public Iterable<Employee> getAllEmployee(){
		 return employeeService.getAllEmployee();
	 }
	 
	 @GetMapping("/get/{employeeId}")
	 public Employee getEmployee(@PathVariable int employeeId ) {
		 return employeeService.getEmployee(employeeId);
	 }
	 
	 @PutMapping("/update")
	 public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	 }
	 
	 @DeleteMapping("/delete/{employeeId}")
	 public void deleteEmployee(@PathVariable int employeeId) {
		 employeeService.deleteEmployee(employeeId);
	 }
	 
	 @GetMapping("/wrong")
	 public Employee somethingIsWrong() {
		 
		 throw new ValidationException("Some thing is wrong");
	 }
	 
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(ValidationException.class)
	 public String exceptionHandler(ValidationException ex) {
		 return ex.getMessage();
	 }
}
