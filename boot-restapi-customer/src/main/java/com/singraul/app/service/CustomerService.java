package com.singraul.app.service;

import java.util.List;

import com.singraul.app.entity.Customer;

public interface CustomerService {
   Customer createCustomer(Customer customer);

	List<Customer> getCustomerList();

	Customer getCustomerById(int custId);

	Customer updateCustomer(Customer customer);

	void deleteCustomerById(int custId);
}
