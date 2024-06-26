package com.withoutxml.spring.jdbc.dao;

import java.util.List;
import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	//public int delete(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
}
