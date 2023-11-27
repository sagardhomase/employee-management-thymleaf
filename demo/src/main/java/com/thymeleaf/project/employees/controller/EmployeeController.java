package com.thymeleaf.project.employees.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.project.employees.model.Employee;
import com.thymeleaf.project.employees.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String index( Model model){
		model.addAttribute("listEmployees", empService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/newEmployeeForm")
	public String addEmployeeForm(Model model) {
		Employee e = new Employee();
		e.setSalary(20000.00);
		model.addAttribute("employee",e);
		List<String> departments = new ArrayList<>();
		departments.add("IT");
		departments.add("HR");
		departments.add("QA");
		model.addAttribute("departments", departments);
		model.addAttribute("managers", empService.getAllEmployees());
		return "new_employee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee emp) {
		empService.addEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping("/updateEmployeeForm/{id}")
	public String updateEmployeeForm(@PathVariable long id, Model model) {
		Employee emp = empService.getEmployee(id);
		model.addAttribute("employee", emp);
		List<String> departments = new ArrayList<>();
		departments.add("IT");
		departments.add("HR");
		departments.add("QA");
		model.addAttribute("departments", departments);
		List<Employee> list = empService.getAllEmployees();
		list.remove(emp);
		model.addAttribute("managers", list);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeForm(@PathVariable long id) {
		empService.deleteEmployee(id);
		return "redirect:/";
	}
}
