package com.webapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.webapp.entiry.Employee;

public interface EmployeeService {

	public ResponseEntity<Employee> save(Employee employee);

	public ResponseEntity<List<Employee>> getAll();

	public ResponseEntity<Employee> getEmployeeByID(String id);

	public ResponseEntity<String> deleteEmployeeById(String id);

	public ResponseEntity<Employee> updateEmployeeByID(Employee employee, String id);

}
