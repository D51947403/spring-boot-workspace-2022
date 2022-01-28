package com.singraul.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.webclient.model.Employee;
import com.singraul.webclient.service.IEmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	IEmployeeService  empService;
	
	@GetMapping(produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	Flux<Employee> findAllEmployee(){
		return empService.findAllEmployee();
	}

	@GetMapping(value="/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	Mono<Employee> findById(@PathVariable("id") long id){
		return empService.findById(id);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Mono<Employee> createEmployee(@RequestBody Employee emp){
		return empService.createEmployee(emp);
	}
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	Mono<Employee> updateEmployee(@RequestBody Employee emp ,@PathVariable("id") long id){
		return empService.updateEmployee(emp);
	}
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	Mono<Void> deleteEmployee(@PathVariable("id") long id){
		return empService.deleteEmployee(id);
	}
}
