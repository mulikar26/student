package com.studentinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentinfo.entity.Student;
import com.studentinfo.service.StudentService;

@RestController("/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public void add(@RequestBody Student s) {
		System.out.println("Add cntr...");
		studentService.addStudent(s);
	}
	
	@PutMapping("/")
	public String update(@RequestBody Student s)  {
		return studentService.saveOrUpdate(s);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		studentService.deleteStudent(id);
	}
	
	@GetMapping("/")
	public List<Student> getAll() {
		return studentService.allStudent();
	}
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentService.get(id);
	}
}
