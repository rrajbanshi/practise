package com.example.rakesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rakesh.exception.StudentNotFoundException;
import com.example.rakesh.model.Student;
import com.example.rakesh.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student save(Student stu) {
		return studentRepository.save(stu);
	}

	@Override
	public List<Student> getAll() {
	    List<Student> list = studentRepository.findAll();
	    if(list.isEmpty()) {
	    	throw new StudentNotFoundException("List is empty");
	    }
	    return studentRepository.findAll();
	}

	@Override
	public Student getStudent(int id) {
	Optional<Student> stu = studentRepository.findById(id);
	if(stu.isEmpty()) {
		throw new StudentNotFoundException("Student Not Found");
	}
	return stu.get();
	}

	@Override
	public Student update(Student stu, int id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isEmpty()) {
			throw new StudentNotFoundException("Student not found" + id);
		}
		stu.setId(id);
		return studentRepository.save(stu);
		
	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> findAllByName() {
		return studentRepository.findAllSortedByName();
	}

	


}
