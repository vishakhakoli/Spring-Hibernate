package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Student;

public interface StudentDao {
	
	public int insert(Student student);
	
	public Student getStudent(int studentId);
	
	public void deleteStudent(int studentId);
	
	public  List<Student> getAllStudent();
	
	public void updateStuent(Student student);
}
