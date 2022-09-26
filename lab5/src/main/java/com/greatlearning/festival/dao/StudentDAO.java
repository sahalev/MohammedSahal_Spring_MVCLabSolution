package com.greatlearning.festival.dao;

import java.util.List;

import com.greatlearning.festival.entity.Student;

public interface StudentDAO {
	public void saveStudent(Student student);
	public void deleteStudent(int id);
	public Student findById(int id);
	public List<Student> findAll();

}
