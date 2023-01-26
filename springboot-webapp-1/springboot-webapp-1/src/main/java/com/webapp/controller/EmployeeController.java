package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.entiry.Employee;
import com.webapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		return employeeService.save(employee);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/getEmployeeByID")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") String id){
		return employeeService.getEmployeeByID(id);
	}
	
	@DeleteMapping("/deleteByID")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") String id){
		return employeeService.deleteEmployeeById(id);
	}
	
	@PutMapping("/updateEmployeeByID/{id}")
	public ResponseEntity<Employee> updateEmployeeByID(@RequestBody Employee employee, @PathVariable("id") String id){
		return employeeService.updateEmployeeByID(employee, id);
	}
}
