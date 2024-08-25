package com.niladri.SpringJdbcStudent.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int roll;
    private String sname;
    private int marks;

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", sname='" + sname + '\'' +
                ", marks=" + marks +
                '}';
    }
}
