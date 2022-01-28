package com.singraul.webclient.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.singraul.webclient.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	WebClient webClient;

	@Override
	public Flux<Employee> findAllEmployee() {

		return webClient.get().uri("/employees").retrieve().bodyToFlux(Employee.class)
				.timeout(Duration.ofMillis(10_000));
	}

	@Override
	public Mono<Employee> findById(long id) {

		return webClient.get().uri("/employee/" + id).retrieve().bodyToMono(Employee.class);
	}

	@Override
	public Mono<Employee> createEmployee(Employee emp) {

		return webClient.post().uri("/employees").body(Mono.just(emp), Employee.class).retrieve()
				.bodyToMono(Employee.class).timeout(Duration.ofMillis(10_000));
	}

	@Override
	public Mono<Employee> updateEmployee(Employee emp) {

		return webClient.put().uri("/employees/" + emp.getId()).body(Mono.just(emp), Employee.class).retrieve()
				.bodyToMono(Employee.class);
	}

	@Override
	public Mono<Void> deleteEmployee(long id) {

		return webClient.delete().uri("/employees/" + id).retrieve().bodyToMono(Void.class);
	}

}
