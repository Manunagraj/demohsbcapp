package com.project.demohsbcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demohsbcapp.entity.Login;
import com.project.demohsbcapp.entity.User;
import com.project.demohsbcapp.repository.LoginRepository;
import com.project.demohsbcapp.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;
    
    @Autowired
    private UserRepository userRepo;

    //@Autowired
    private User user;

    public User fetchLoginByEmailIdAndPassword(String emailId, String password){


//        if(user==null)
//            throw new UserServiceException("Incorrect Email or Password");


            return userRepo.findByEmailIdAndPassword(emailId, password);


    }
    
    public Login fetchLoginAdminByEmailIdAndPassword(String emailId, String password){


//      if(user==null)
//          throw new UserServiceException("Incorrect Email or Password");


          return repo.findByEmailIdAndPassword(emailId, password);


  }
    
	public List<User> getUsers()
	{
		List<User> users = (List<User>) userRepo.findAll();
		
		return users;
	}
	
	public void deleteUser(int userId) {
		
		User userNew = userRepo.findByUserId(userId);
		 
		userRepo.delete(userNew);
	}
	
	
	/*updated code for edit feature*/
	public User updateUser(User user) {
		User existuser = userRepo.findById(user.getUserId()).orElse(user);
		existuser.setUserId(user.getUserId());
		existuser.setName(user.getName());
		existuser.setEmailId(user.getEmailId());
		existuser.setDob(user.getDob());
		existuser.setPassword(user.getPassword());
		


		return userRepo.save(existuser);

	}
}