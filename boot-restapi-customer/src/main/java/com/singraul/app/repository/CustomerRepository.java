package com.singraul.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
