package com.project.demohsbcapp.dto;

import java.time.LocalDate;

public class UserDto {
    private int userId;
    private String name;
    private String emailId;
    private LocalDate dob;

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


    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob) { this.dob = dob; }
}
