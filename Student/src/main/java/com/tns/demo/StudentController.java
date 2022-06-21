package com.tns.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//marking class as controller
@RestController
public class StudentController 
{
	//autowired studentservice class
	@Autowired
	public StudentService service;
	
	// RESTful API methods for Retrieval operations
	//creating a get mapping that retrives all the student detail from the database
	 @GetMapping("/students")
	 public List<Student> list() 
	 {
	 return service.listAll();
	 }
	 //creating a get mapping that retrives the detail of the specific student
	 @GetMapping("/students/{id}")
	 public ResponseEntity<Student> get(@PathVariable Integer id) 
	 {
	 try
	 {
	 Student student = service.get(id);
	 return new ResponseEntity<Student>(student, HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 //creating post mapping that for the student detail in database
	 // RESTful API method for Create operation
	 @PostMapping("/students")
	 public void add(@RequestBody Student student) 
	 {
	 service.save(student);
	 }
	 // RESTful API method for Update operation
	//creating put mapping that updates the student detail in database
	 
	 @PutMapping("/students/{id}")
	 public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) 
	 {
	 try
	 {
	 Student existStudent = service.get(id);
	 service.save(student);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 // RESTful API method for Delete operation
		//creating delete mapping that deletes the student specific student in database

	 @DeleteMapping("/students/{id}")
	 public void delete(@PathVariable Integer id) 
	 {
	 service.delete(id);
	 }
}
