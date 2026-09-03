package com.deepak;
import com.deepak.model.Student;
import com.deepak.util.DatabaseConnection;
import com.deepak.dao.StudentDAO;
import java.util.Scanner;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println();

        boolean running = true;
        while(running) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");
            if(sc.hasNextInt()) {
                int choice = sc.nextInt();

                System.out.println();

                switch (choice) {
                    case 1: {
                        addStudent(studentDAO, sc);
                        break;
                    }
                    case 2:
                        getAllStudents(studentDAO);
                        break;
                    case 3:
                        getStudentByRollNo(studentDAO, sc);
                        break;
                    case 4: {
                        updateStudent(studentDAO, sc);
                        break;
                    }
                    case 5: {
                        deleteStudent(studentDAO, sc );
                        break;
                    }
                    case 6:
                        System.out.println("Exiting...");
                        running = false;
                }

                System.out.println();
            }else{
                System.out.println("Invalid Input, Please enter a number!");
                sc.nextLine();
                System.out.println();
            }

        }
        sc.close();

    }
    public static void addStudent(StudentDAO studentDAO, Scanner sc){
        System.out.println("Add Student selected");
        System.out.println();
        System.out.print("Enter the Roll Number: ");
        String rollNo = sc.next();

        sc.nextLine();

        System.out.print("Enter the Name: ");
        String name = sc.nextLine();

        System.out.print("Enter the Email: ");
        String email = sc.next();

        System.out.print("Enter the Phone Number: ");
        String phoneNo = sc.next();

        System.out.print("Enter the Department ID: ");
        int departmentId = sc.nextInt();

        Student student = new Student(
                rollNo, name, email, phoneNo, departmentId
        );

        try {
            studentDAO.addStudent(student);
        } catch (SQLException e) {
            System.out.println("Cannot add Student!");
            e.printStackTrace();
        }

    }

    public static void getAllStudents(StudentDAO studentDAO){
        System.out.println("View All Students selected");
        System.out.println();
        try {
            List<Student> students = studentDAO.getAllStudents();

            for (Student s : students) {
                System.out.println(
                        s.getRollNo() + " | " +
                                s.getName() + " | " +
                                s.getEmail() + " | " +
                                s.getPhoneNo() + " | " +
                                s.getDepartmentId()
                );
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch students!");
            e.printStackTrace();
        }
    }

    public static void getStudentByRollNo(StudentDAO studentDAO, Scanner sc){
        System.out.println("Find Student selected");

        System.out.print("Enter the Roll Number of the student: ");
        String roll_number = sc.next();

        try {
            Student s = studentDAO.getStudentByRollNo(roll_number);
            if (s != null) {
                System.out.println(
                        s.getRollNo() + " | " +
                                s.getName() + " | " +
                                s.getEmail() + " | " +
                                s.getPhoneNo() + " | " +
                                s.getDepartmentId()
                );
            } else System.out.println("Student Not Found");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(StudentDAO studentDAO, Scanner sc){
        System.out.println("Update Student selected");

        System.out.print("Enter the Roll Number: ");
        String rollNo = sc.next();

        sc.nextLine();

        System.out.print("Enter the Name: ");
        String name = sc.nextLine();

        System.out.print("Enter the Email: ");
        String email = sc.next();

        System.out.print("Enter the Phone Number: ");
        String phoneNo = sc.next();

        System.out.print("Enter the Department ID: ");
        int departmentId = sc.nextInt();

        Student student = new Student(
                rollNo, name, email, phoneNo, departmentId
        );
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(StudentDAO studentDAO, Scanner sc){
        System.out.println("Delete Student selected");
        System.out.print("Enter the Roll Number: ");
        String rollNo = sc.next();
        try {
            studentDAO.deleteStudent(rollNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}