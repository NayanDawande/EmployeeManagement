package com.spring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Exception.ResourceNotFoundException;
import com.spring.dao.employeeRepository;
import com.spring.entity.employees;

@Service
public class EmployeeService {

	private final employeeRepository employeeRepo;

	@Autowired
	EmployeeService(employeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public employees addEmp(employees emp) {

		emp.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(emp);

	}
	
	public employees getSingleID(int id) {
		return employeeRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("User by id "+id+" was not found")) ;
	}

	public List<employees> list() {
		return  employeeRepo.findAll();
	}
	
	public void remove(int id) {
		employeeRepo.deleteById(id);
	}
	
	public employees updateID(employees emp) {
		return employeeRepo.save(emp);
	}
	
	
	
}
