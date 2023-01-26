package com.webapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webapp.entiry.Employee;
import com.webapp.exception.EmployeeNotFoundException;
import com.webapp.repository.EmployeeRepository;
import com.webapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Employee> save(Employee employee) {
		employee.setEmpID(UUID.randomUUID().toString());
		Employee temp=null;
		try {
			temp = employeeRepository.save(employee);
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> response = employeeRepository.findAll();
		if(response.isEmpty()) {
			throw new EmployeeNotFoundException("Employee Not Found "+HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeByID(String id) {
		Optional<Employee> response = employeeRepository.findById(id);
		if(!response.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found"+ HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(response.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteEmployeeById(String id) {
		if(employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("Employee not foud"+HttpStatus.NOT_FOUND);
		}
		employeeRepository.deleteById(id);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Employee> updateEmployeeByID(Employee employee, String id) {
		if(employeeRepository.existsById(id)) {
			Employee response = employeeRepository.findById(id).get();
			response.setFirstName(employee.getFirstName());
			response.setLastName(employee.getLastName());
			response.setEmail(employee.getEmail());
			Employee save = employeeRepository.save(response);
			return new ResponseEntity<Employee>(save, HttpStatus.CREATED);
		}else {
			throw new EmployeeNotFoundException("Employee not found"+HttpStatus.NOT_FOUND);
			
		}
		
	}
}
