package com.singraul.mockito.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.singraul.mockito.model.Employee;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeControllerIntegrationTest {
   @Autowired
   EmployeeController employeeController;
   
   @Test
   public void test_creatEmployee() {
	   Employee emp = new Employee("Devendra", "Singraul");
	   
	   Employee createResult = employeeController.creatEmployee(emp);
	   
	    Assertions.assertThat(createResult.getEmployeeId()).isNotNull();
	    Assertions.assertThat(createResult.getFirstName()).isEqualTo("Devendra");
	    Assertions.assertThat(createResult.getLastName()).isEqualTo("Singraul");
   }
   
   @Test
   public void test_getAllEmployee() {
   Employee emp1 = new Employee("Devendra", "Singraul");
   Employee emp2 = new Employee("Monish", "Singraul");
   Employee emp3 = new Employee("Joshep", "Singraul");
   Employee emp4 = new Employee("Anand", "Singraul");
	    employeeController.creatEmployee(emp1);
	    employeeController.creatEmployee(emp2);
	    employeeController.creatEmployee(emp3);
	    employeeController.creatEmployee(emp4);
	 
	    Iterable<Employee> getAllResult = employeeController.getAllEmployee();
	    
	    Assertions.assertThat(getAllResult).first().hasFieldOrPropertyWithValue("firstName", "Devendra");
	    Assertions.assertThat(getAllResult).first().hasFieldOrPropertyWithValue("lastName", "Singraul");
   }
}
