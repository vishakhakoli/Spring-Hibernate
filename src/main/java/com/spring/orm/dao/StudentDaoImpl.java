package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public StudentDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public StudentDaoImpl() {
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//Adding new student
	@Override
	@org.springframework.transaction.annotation.Transactional
	public int insert(Student student) {
		
		return (Integer)this.hibernateTemplate.save(student);
	}

	//Get single student
	@Override
	public Student getStudent(int studentId) {
		Student student= this.hibernateTemplate.get(Student.class, studentId);
		 return  student;
	}

	//deleteing student
	@Override
	@Transactional
	public void deleteStudent(int studentId) {
		Student student= this.hibernateTemplate.get(Student.class, studentId);
		 this.hibernateTemplate.delete(student);
		
	}

	//get All student list
	@Override
	public List<Student> getAllStudent() {
		List<Student> student= this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

	@Override
	public void updateStuent(Student student) {
		 this.hibernateTemplate.update(student);
	}

	

}
