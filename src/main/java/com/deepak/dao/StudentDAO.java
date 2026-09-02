package com.deepak.dao;

import com.deepak.util.DatabaseConnection;
import com.deepak.model.Student;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class StudentDAO {
    public void addStudent(Student student) throws SQLException {
        String sql = """
                insert into students
                (roll_no, name, email, phone_no, department_id)
                values (?,?,?,?,?)
                """;


        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, student.getRollNo());
        ps.setString(2, student.getName());
        ps.setString(3, student.getEmail());
        ps.setString(4, student.getPhoneNo());
        ps.setInt(5, student.getDepartmentId());

        int rowsAffected = ps.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException{

        List<Student> students = new ArrayList<>();
        String sql = """
                select * from students
                """;

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Student student = new Student(
                    rs.getString("roll_no"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_no"),
                    rs.getInt("department_id")
            );
            students.add(student);

        }
        return students;
    }

    public Student getStudentByRollNo(String rollNo) throws SQLException{

        String sql = """
                select * from students
                where roll_no = ?
                """;
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, rollNo);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            Student student = new Student(
                    rs.getString("roll_no"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone_no"),
                    rs.getInt("department_id")
            );
            return student;
        }
        return null;


    }

    public void updateStudent(Student student) throws SQLException{
        String sql = """
                update students 
                set name = ?, email = ?,phone_no = ?, department_id = ?
                where roll_no = ? 
                """;

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getPhoneNo());
        ps.setInt(4, student.getDepartmentId());
        ps.setString(5,student.getRollNo());

        int rowsAffected = ps.executeUpdate();
        System.out.println("Rows Updated:" + rowsAffected);
    }

    public void deleteStudent(String rollNo) throws SQLException{
        String sql = """
                delete from students where roll_no = ? 
                """;
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, rollNo);

        int rowsAffected = ps.executeUpdate();
        System.out.println("Rows deleted: " + rowsAffected);
    }
}
