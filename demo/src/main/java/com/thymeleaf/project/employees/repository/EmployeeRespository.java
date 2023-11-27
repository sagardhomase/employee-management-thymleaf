package com.thymeleaf.project.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thymeleaf.project.employees.model.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {

}
