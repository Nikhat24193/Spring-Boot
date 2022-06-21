package com.tns.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//defining the business logic
@Service
@Transactional
public class StudentService 
{
	@Autowired
	private StudentRepository repo;
	
	//getting all student record by using the method findAll() of JPA repository
	
	public List<Student> listAll() 
	 {
	 return repo.findAll();
	 }
	
	//getting a specific record by using the method findById() of crud repository
	public Student get(Integer id) 
	 {
	 return repo.findById(id).get();
	 }
	//saving a specific record by using the method save() of crud repository
	
	 public void save(Student student) 
	 {
	 repo.save(student);
	 }
	 
	 
		//deleting a specific record by using the method deleteById() of crud repository

	 public void delete(Integer id) 
	 {
	 repo.deleteById(id);
	 }
}
