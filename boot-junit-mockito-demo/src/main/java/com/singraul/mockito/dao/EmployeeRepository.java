package com.singraul.mockito.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.singraul.mockito.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
}
