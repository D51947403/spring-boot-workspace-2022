package com.singraul.webclient.service;

import com.singraul.webclient.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
	
	Flux<Employee> findAllEmployee();

	Mono<Employee> findById(long id);

	Mono<Employee> createEmployee(Employee emp);

	Mono<Employee> updateEmployee(Employee emp);

	Mono<Void> deleteEmployee(long id);
}
