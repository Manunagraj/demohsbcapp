package com.project.demohsbcapp.entity;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
//@Table(name= "employee")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int empId;
//
//    private String name;
//    private String emailId;
//    private String department;
//    private String location;
//    private LocalDate dob;
//    private String password;
//
//    public int getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(int empId) {
//        this.empId = empId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public LocalDate getDob() { return dob; }
//
//    public void setDob(LocalDate dob) { this.dob = dob; }
//
//    public String getPassword() { return password; }
//
//    public void setPassword(String password) { this.password = password; }
//}
@Entity
@Table(name= "employee")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
//    private int empId;
    private int userId;

    private String name;
    private String emailId;
//    private String department;
//    private String location;
    private LocalDate dob;
    private String password;

//    public int getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(int empId) {
//        this.empId = empId;
//    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
