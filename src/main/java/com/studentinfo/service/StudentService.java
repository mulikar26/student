package com.studentinfo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.studentinfo.dao.StudentDao;
import com.studentinfo.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public void addStudent(Student s) {
		studentDao.save(s);
		System.out.println("Student Saved...");	}
	
	public void deleteStudent(int id) {
	
		studentDao.deleteById(id);
		System.out.println("Student Deleted...");
	}
	
	public List<Student> allStudent(){
		ArrayList<Student> list = new ArrayList<>();
		Iterable<Student> itr = studentDao.findAll();
		Iterator<Student> i = itr.iterator();
		while(i.hasNext()) {
			list.add(i.next());
		}
		return list;
	}
	
	public String saveOrUpdate(Student s)  {
		 int id = s.getId();
		try {
		Student updateStudent = studentDao.findById(id)
                .orElseThrow(() -> new Exception("Student not exist with id: " + id));

        updateStudent.setName(s.getName());
        updateStudent.setDiv(s.getDiv());
        updateStudent.setAge(s.getAge());
        studentDao.save(updateStudent);
		System.out.println("Student Updated");
		}
		catch(Exception e) {
			//e.getMessage();
			e.printStackTrace();
			return "Error in upadate";
		}
		
		return "upadted";
		
		
	}
	
	
	public Student get(int id) {
		Optional<Student> ref = studentDao.findById(id);
		Student s = ref.get();
		return s; 
	}
}
