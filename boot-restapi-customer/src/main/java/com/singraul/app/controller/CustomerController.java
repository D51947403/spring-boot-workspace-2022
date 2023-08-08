package com.singraul.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.app.entity.Customer;
import com.singraul.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
//to enable angular application to interact with spring boot application
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer createdCustomer = service.createCustomer(customer);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<Customer>(createdCustomer, headers, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomerList() {

		List<Customer> custList = service.getCustomerList();

		return new ResponseEntity<List<Customer>>(custList, HttpStatus.OK);
	}

	@GetMapping("{custId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("custId") int custId) {

		Customer customerFromDB = service.getCustomerById(custId);

		return new ResponseEntity<Customer>(customerFromDB, HttpStatus.ACCEPTED);

	}

	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		Customer updateCustomer = service.updateCustomer(customer);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<Customer>(updateCustomer, headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{custId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("custId") int custId) {

		service.deleteCustomerById(custId);

		return new ResponseEntity<String>("Customer deleted successfully.", HttpStatus.OK);

	}

}
