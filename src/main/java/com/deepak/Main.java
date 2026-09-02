package com.deepak;
import com.deepak.model.Student;
import com.deepak.util.DatabaseConnection;
import com.deepak.dao.StudentDAO;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

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


        try{
            Student s = studentDAO.getStudentByRollNo("210823104030");
            if(s!=null){
                System.out.println();
                System.out.println(
                                s.getRollNo()+" | "
                                + s.getName()+" | "
                                +s.getEmail()+" | "
                                +s.getPhoneNo()+" | "
                                +s.getDepartmentId()
                );
            }
            else System.out.println("No Student Found");
        }catch (SQLException e){
            System.out.println("No Student Found!");
            e.printStackTrace();
        }

        try{
            Student student = new Student(
                    "210823104031",
                    "Ajith",
                    "ajith@gmail.com",
                    "9092065178",
                    1
            );
            studentDAO.updateStudent(student);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}