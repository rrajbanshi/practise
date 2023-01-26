package com.student.service;

import java.rmi.StubNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.student.exception.StudentNotFound;
import com.student.model.Student;

public interface StudentService {

	public Student save(Student student);
	
	public List<Student> getAll();
	
	public Student findByid(int id);
	
	public String deleteById(int id);

//	public Student update(Student student);

	public ResponseEntity<Student> updateStudentById(int id, Student student);
	
}
