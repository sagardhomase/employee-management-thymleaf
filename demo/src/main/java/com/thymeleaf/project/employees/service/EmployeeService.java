package com.thymeleaf.project.employees.service;

import java.util.List;

import com.thymeleaf.project.employees.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee emp);
	
	Employee getEmployee(long id);
	
	void deleteEmployee(long id);
}
