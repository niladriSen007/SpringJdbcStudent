package com.niladri.SpringJdbcStudent;

import com.niladri.SpringJdbcStudent.model.Student;
import com.niladri.SpringJdbcStudent.services.StudentServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcStudentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcStudentApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setRoll(1);
		student.setSname("Niladri");
		student.setMarks(100);
//		System.out.println(student.toString());
//		System.out.println("Hello Spring Boot");

		StudentServices studentServices = context.getBean(StudentServices.class);
		studentServices.addStudent(student);

		List<Student> studentList = studentServices.getStudentList();
		for (Student s: studentList) {
			System.out.println(s.toString());
		}



	}

}
