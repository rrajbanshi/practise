package com.webapp.entiry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "employee")
@Entity
public class Employee {

	@Id
	private String empID;
	private String firstName;
	private String lastName;
	private String email;
	
}
