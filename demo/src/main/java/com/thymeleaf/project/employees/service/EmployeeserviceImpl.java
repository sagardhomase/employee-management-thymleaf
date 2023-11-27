package com.thymeleaf.project.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleaf.project.employees.model.Employee;
import com.thymeleaf.project.employees.repository.EmployeeRespository;

@Service
public class EmployeeserviceImpl implements EmployeeService{

	@Autowired
	EmployeeRespository employeeRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return employeeRepo.save(emp);
	}

	@Override
	public Employee getEmployee(long id) {
		Optional<Employee> empOptional = employeeRepo.findById(id);
		Employee emp = null;
		if(empOptional.isPresent()) {
			emp = empOptional.get();
		}else {
			throw new RuntimeException("No Employee Found");
		}
		return emp;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
	}

}
