package com.singraul.mockito.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int employeeId;
	 private String firstName;
	 private String lastName;
	 
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	 
	 public Employee() {
		 
	 }
	public int getEmployeeId() {
		return employeeId;
	}
	 public void setEmployeeId(int employeeId) {
		 this.employeeId=employeeId;
	 }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	 
}
