package com.deepak.dao;

import com.deepak.util.DatabaseConnection;
import com.deepak.model.Student;

import java.sql.*;

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

    public void getAllStudents() throws SQLException{
        String sql = """
                select * from students
                """;

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String rollNo = rs.getString("roll_no");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phoneNo = rs.getString("phone_no");
            int departmentId = rs.getInt("department_id");

            System.out.println(rollNo+" | "+name+" | "+email+" | "+phoneNo+" | "+departmentId);

        }
    }
}
