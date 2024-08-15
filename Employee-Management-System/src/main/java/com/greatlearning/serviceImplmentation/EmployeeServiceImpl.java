package com.greatlearning.serviceImplmentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.model.Employee;
import com.greatlearning.repository.EmployeeRepository;
import com.greatlearning.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> getlistOfEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployToList(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmployeebyId(Long id) {

		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
		return emp;
	}

	@Override
	public Employee updateEmployForm(Long id, Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeFromList(Employee employee) {
		employeeRepository.delete(employee);
	}

}
