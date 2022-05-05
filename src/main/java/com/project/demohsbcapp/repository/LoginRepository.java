package com.project.demohsbcapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demohsbcapp.entity.Login;
import com.project.demohsbcapp.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

//     public User findByEmailIdAndPassword(String emailId , String Password);
	public Login findByEmailIdAndPassword(String emailId , String Password);
}
