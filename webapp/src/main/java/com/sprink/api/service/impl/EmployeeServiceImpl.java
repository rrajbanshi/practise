package com.sprink.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprink.api.entity.Employee;
import com.sprink.api.repository.EmployeeRepository;
import com.sprink.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}
}
