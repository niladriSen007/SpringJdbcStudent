package com.niladri.SpringJdbcStudent.repository;

import com.niladri.SpringJdbcStudent.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudentToDatabase(Student student) {
        String query = "insert into student (roll,sname,marks) values (?,?,?)";
        int rows = jdbcTemplate.update(query, student.getRoll(), student.getSname(), student.getMarks());
        System.out.println("Rows Inserted: " + rows);
    }

    public List<Student> getStudentListFromDatabase() {
        String query = "select * from student";
        RowMapper<Student> studentMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setRoll(rs.getInt("roll"));
                student.setSname(rs.getString("sname"));
                student.setMarks(rs.getInt("marks"));
                return student;
            }
        };
        List<Student> students = jdbcTemplate.query(query, studentMapper);
        return students;
    }
}
