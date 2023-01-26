package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.exception.StudentNotFound;
import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(value="/student")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return new ResponseEntity<>(service.save(student), HttpStatus.CREATED);
		
//		return new ResponseEntity<>(service.save(student), HttpStatus.CREATED);
	}
	
	@GetMapping(value="/student")
	public ResponseEntity<List<Student>> getAll(){
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	@GetMapping(value="/student/{id}")
	public ResponseEntity<Student> findById(@PathVariable int id) throws StudentNotFound{
		return new ResponseEntity<>(service.findByid(id), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@PathVariable int id){
		return new ResponseEntity<>(service.deleteById(id), HttpStatus.CREATED);
	}
	
	
//	@DeleteMapping(value="/student/{id}")
//	public ResponseEntity<String>  deleteById(@PathVariable("id") int id){
//		return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
//	}
	
//	@PutMapping("/updateStudentById/{id}")
//	public ResponseEntity<Student> updateStudentById(@PathVariable("id") int id, @RequestBody Student student){
//		return new ResponseEntity<>(service.updateStudentById(id, student),HttpStatus.CREATED);
//	}
	
}
