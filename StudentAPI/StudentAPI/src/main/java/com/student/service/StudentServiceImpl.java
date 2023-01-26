package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.exception.StudentNotFound;
import com.student.model.Student;
import com.student.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student save(Student student) {
		
		return repo.save(student);
	}

	@Override
	public List<Student> getAll() {
		
		return repo.findAll();
	}

	@Override
	public Student findByid(int id) {
		Optional<Student> student=repo.findById(id);
		if(student.isEmpty()) {
			throw new StudentNotFound("Student not found");
		}
		return student.get();
	}
//	public Student deleteById(int id) {
//		repo.deleteById(id);
//		if(student.isEmpty()) {
//			throw new StudentNotFound("Student not found");
//		}
//		return student.get();
//	}

	@Override
	public String deleteById(int id) {
		Optional<Student> student=repo.findById(id);
		if(student.isEmpty()) {
			throw new StudentNotFound("Student not found");
		}
		repo.deleteById(id);
		return "Student Deleted Successfully";
	}

	@Override
	public ResponseEntity<Student> updateStudentById(int id, Student student) {
		if(repo.existsById(id)) {
			Student response = repo.findById(id).get();
			response.setName(student.getName());
			response.setEmail(student.getEmail());
			Student save = repo.save(response);
//			return new ResponseEntity<Student>(save, HttpStatus.CREATED);
			return new ResponseEntity<Student>(save, HttpStatus.CREATED);
		}else {
			throw new StudentNotFound("Student not found"+ HttpStatus.NOT_FOUND);
		}
	}

//	@Override
//	public Student update(Student student) {
//		 Optional<Student> student=repo.findById(student.ge)
//		return null;
//	}

}
