package com.studentinfo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentinfo.entity.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer>{

}
