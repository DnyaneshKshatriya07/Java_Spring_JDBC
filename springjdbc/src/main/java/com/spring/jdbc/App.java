package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program Started......" );
        @SuppressWarnings("resource")
        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//        JdbcTemplate template= context.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        String query="insert into student(id, name, city) values (?,?,?)";
//        
//        int result = template.update(query,100,"Ayush","Chandwad");
//        System.out.println("Number of Record inserted...."+result);
        
        StudentDao studentDao= context.getBean("StudentDao",StudentDao.class);
          //Insert Into DataBase 
//        Student student= new Student();
//        student.setId(450);
//        student.setName("rahul");
//        student.setCity("pune");
//        
//        int result=studeantDao.insert(student);
//        System.out.println("Student added "+result);
        
        
//        //Update The Database
//        Student student= new Student();
//        student.setId(400);
//        student.setName("vedant");
//        student.setCity("mumbai");
//        
//        int result=studentDao.change(student);
//        System.out.println("Student changed "+result);
        
        
      //Delete From Database
//        Student student= new Student();
//        student.setId(440);
//                
//        int result=studentDao.delete(student);
//        System.out.println("Student Delete "+result);
        
//        System.out.println("Enter the Id that you want to delete:- ");
//        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt();
//        int result=studentDao.delete(a);
//        System.out.println("Student Delete "+result);
        
        //Select From Database using single object
//        Student student= studentDao.getStudent(100);
//        System.out.println(student);

        //Select From Database using multiple object
        List<Student> students= studentDao.getAllStudents();
        for(Student s: students){
        	System.out.println(s);
        }   
    }
}
