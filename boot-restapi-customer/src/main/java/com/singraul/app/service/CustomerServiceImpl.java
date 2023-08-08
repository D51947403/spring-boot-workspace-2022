package com.singraul.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singraul.app.entity.Customer;
import com.singraul.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> getCustomerList() {

		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(int custId) {
		// this is returning Option class object
		return repository.findById(custId).get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Customer existingCustomer = repository.findById(customer.getCustId()).get();

		if (existingCustomer != null) {
			existingCustomer.setCustName(customer.getCustName());
			existingCustomer.setType(customer.getType());
			existingCustomer.setAddress(customer.getAddress());
		} else {
			throw new RuntimeException("Customer not found.");
		}
		return repository.save(existingCustomer);
	}

	@Override
	public void deleteCustomerById(int custId) {
		Customer existingCustomer = repository.findById(custId).get();
		if (existingCustomer != null) {
			repository.deleteById(custId);
		} else {
			throw new RuntimeException("Customer not found.");
		}
	}

}
