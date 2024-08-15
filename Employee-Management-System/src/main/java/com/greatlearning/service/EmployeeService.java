package com.greatlearning.service;



import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.greatlearning.model.Employee;

@Component
public interface EmployeeService {
	Iterable<Employee> getlistOfEmployees();
	Employee addEmployToList(Employee employee);
	Employee findEmployeebyId(@PathVariable ("id") Long id);
	Employee updateEmployForm(@PathVariable ("id") Long id,Employee employee);
	void deleteEmployeeFromList(Employee employee);
}
