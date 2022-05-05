package com.project.demohsbcapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailID(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
