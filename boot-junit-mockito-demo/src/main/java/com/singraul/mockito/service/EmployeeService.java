package com.singraul.mockito.service;

import com.singraul.mockito.model.Employee;

public interface EmployeeService {

	Employee save(Employee emp);

	Iterable<Employee> getAllEmployee();

	Employee getEmployee(int employeeId);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(int employeeId);

}
