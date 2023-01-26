package com.example.rakesh.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.rakesh.exception.ResponseMessage;
import com.example.rakesh.model.Student;
import com.example.rakesh.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	@PostMapping
	public Student InsertStudent(@RequestBody Student stu) {
		return studentService.save(stu);
	}
	
	@GetMapping("/{id}")
	public Student findStudent(@PathVariable("id") int id) {
		return studentService.getStudent(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAll(){
		return new ResponseEntity<List<Student>>(studentService.getAll(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> update(@RequestBody Student student, @PathVariable int id){
		studentService.update(student, id);
		ResponseMessage mesg = new ResponseMessage();
		mesg.setErrorCode(HttpStatus.OK.value());
		mesg.setMessage("Updated SuccessFully");
	    return new ResponseEntity<ResponseMessage>(mesg, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		studentService.delete(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/api/{name}")
	public List<Student> findByName(@PathVariable String name){
		return studentService.findByName(name);
	}
	
	@GetMapping("/apii")
	public List<Student> getAllByName(){
		return studentService.findAllByName();
	}
}
