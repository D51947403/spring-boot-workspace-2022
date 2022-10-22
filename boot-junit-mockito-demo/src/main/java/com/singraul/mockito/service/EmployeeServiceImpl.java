package com.singraul.mockito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singraul.mockito.dao.EmployeeRepository;
import com.singraul.mockito.handler.RecordNotFoundException;
import com.singraul.mockito.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> result = (List<Employee>) employeeRepository.findAll();
		if (result.size() > 0) {
			return result;
		}
		return new ArrayList<Employee>();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		return empOptional.get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> empOptional = employeeRepository.findById(employee.getEmployeeId());
		if (empOptional.isPresent()) {
			Employee newEmployee = empOptional.get();
			newEmployee.setFirstName(employee.getFirstName());
			newEmployee.setLastName(employee.getLastName());
			newEmployee = employeeRepository.save(newEmployee);
			return newEmployee;
		}else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			employeeRepository.deleteById(employeeId);
		}else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}
