package com.sprink.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprink.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
