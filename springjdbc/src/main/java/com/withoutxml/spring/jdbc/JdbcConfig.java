package com.withoutxml.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

@Configuration
public class JdbcConfig {
	
	@Bean(name={"ds"})
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Dnyanesh@7123");
		return ds;
	}

	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate(){
		JdbcTemplate jdbcTemplate= new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name={"studentDao"})
	public StudentDao getStudentDao(){
		StudentDao studentDao= new StudentDaoImpl();
		((StudentDaoImpl) studentDao).setJdbcTemplate(getTemplate());
		return studentDao;
	}
}
