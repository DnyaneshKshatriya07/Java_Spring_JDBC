package com.withoutxml.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate1;
	
	public int insert(Student student) {
		String query="insert into student(id, name, city) values (?,?,?)";
	    int result = this.jdbcTemplate1.update(query,student.getId(),student.getName(),student.getCity());
		
	    return result;
	}
	
	public int change(Student student) {
		String query="update student set name=?, city=? where id=?";
	    int result = this.jdbcTemplate1.update(query,student.getName(),student.getCity(),student.getId());
		
	    return result;
	}
	
//	public int delete(Student student) {
//		String query="delete from student where id=?";
//	    int result = this.jdbcTemplate1.update(query,student.getId());
//		
//	    return result;
//	}
	
	public int delete(int studentId) {
		String query="delete from student where id=?";
	    int result = this.jdbcTemplate1.update(query,studentId);
		
	    return result;
	}
	
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowmapper =new RowMapperImpl();
	    Student student= this.jdbcTemplate1.queryForObject(query, rowmapper,studentId);
		
	    return student;
	}

	public List<Student> getAllStudents() {
		String query="select * from student";
	    List<Student> students= this.jdbcTemplate1.query(query, new RowMapperImpl());
		
	    return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate1;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate1 = jdbcTemplate;
	}
}
