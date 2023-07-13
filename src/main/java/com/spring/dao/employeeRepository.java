package com.spring.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.employees;

public interface employeeRepository extends JpaRepository<employees, Integer>{

	void deleteById(int id);

	Optional<employees> findById(int id);

}
