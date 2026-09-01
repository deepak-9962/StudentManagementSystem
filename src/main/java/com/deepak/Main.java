package com.deepak;
import com.deepak.model.Student;
import com.deepak.util.DatabaseConnection;
import com.deepak.dao.StudentDAO;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(
                "210823104033",
                "Akash",
                "akash@gmail.com",
                "8778022435",
                1
        );

        StudentDAO studentDAO = new StudentDAO();

//        try {
//            studentDAO.addStudent(student);
//            System.out.println("Student Added Successfully");
//        }catch(SQLException e){
//            System.out.println("Failed to add the Student");
//            e.printStackTrace();
//        }


        try {
            List<Student> students = studentDAO.getAllStudents();

            for (Student s : students){
                System.out.println(
                        s.getRollNo()+" | "
                        + s.getName()+" | "
                        +s.getEmail()+" | "
                        +s.getPhoneNo()+" | "
                        +s.getDepartmentId()
                );
            }
        }catch (SQLException e){
            System.out.println("Failed to fetch the Student");
            e.printStackTrace();
        }
    }
}