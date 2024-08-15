package com.greatlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.model.Employee;
import com.greatlearning.serviceImplmentation.EmployeeServiceImpl;

@Controller
@ComponentScan(basePackages = "com.greatlearning")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeServiceImpl.getlistOfEmployees());
		return "employees";
	}

	@GetMapping("/add")
	public String addEmployeeForm(Employee employee) {
		return "add-employee";
	}

	@PostMapping("/add")
	public String addEmployee(Employee employee) {
		employeeServiceImpl.addEmployToList(employee);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editEmployeeForm(@PathVariable("id") Long id, Model model) {
		Employee employee = employeeServiceImpl.findEmployeebyId(id);
		model.addAttribute("employee", employee);
		return "edit-employee";
	}

	@PostMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") Long id, Employee employee, Model model) {
		employeeServiceImpl.updateEmployForm(id, employee);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeServiceImpl.findEmployeebyId(id);
		employeeServiceImpl.deleteEmployeeFromList(employee);
		return "redirect:/";
	}
}
