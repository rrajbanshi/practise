package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.entiry.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
    
//	public Employee findByFirstNameAndLastName(String firstName, String lastName);
}
