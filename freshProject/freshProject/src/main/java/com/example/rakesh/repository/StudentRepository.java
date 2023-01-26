package com.example.rakesh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rakesh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//native query
	public List<Student> findByName(String name);
	
	@Query(value = "SELECT e FROM Student e ORDER BY name")
	public List<Student> findAllSortedByName();

}
