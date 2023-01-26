package com.example.rakesh.service;

import java.util.List;

import com.example.rakesh.model.Student;

public interface StudentService {
	
	public Student save(Student stu);
	public List<Student> getAll();
	public Student getStudent(int id);
	public Student update(Student stu, int id);
	public void delete(int id);
	
	public List<Student> findByName(String name);
	
	public List<Student> findAllByName();
	

}
