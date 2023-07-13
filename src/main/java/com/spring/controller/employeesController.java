package com.spring.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.employees;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping(("/v1/api"))
public class employeesController {

	private final EmployeeService employeeService;

	public employeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<employees>> getAll() {
		List<employees> employeesOne = employeeService.list();
		return new ResponseEntity<List<employees>>(  employeesOne, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<employees> getAll(@PathVariable int id) {
		employees employees = employeeService.getSingleID(id);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<employees> insert(@RequestBody employees emp) {
		employees employee = employeeService.addEmp(emp);
		return new ResponseEntity<employees>(employee, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<employees> update(@RequestBody employees emp) {
		employees employee = employeeService.updateID(emp);
		return new ResponseEntity<employees>(employee, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<employees> update(@PathVariable int id) {
		 employeeService.remove(id);
		return new ResponseEntity<employees>( HttpStatus.OK);

	}
	
	

}
