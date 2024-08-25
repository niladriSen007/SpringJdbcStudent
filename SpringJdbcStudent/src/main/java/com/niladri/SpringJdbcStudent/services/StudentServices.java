package com.niladri.SpringJdbcStudent.services;

import com.niladri.SpringJdbcStudent.model.Student;
import com.niladri.SpringJdbcStudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudentToDatabase(student);
        System.out.println("Student Added");
    }
    public void updateStudent() {
        System.out.println("Student Updated");
    }
    public void deleteStudent() {
        System.out.println("Student Deleted");
    }
    public List<Student> getStudentList() {
        System.out.println("Student Fetched");
        return studentRepository.getStudentListFromDatabase();
    }
}
