package com.project.demohsbcapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demohsbcapp.dto.LoginStatus;
import com.project.demohsbcapp.dto.Status;
import com.project.demohsbcapp.dto.Status.StatusType;
import com.project.demohsbcapp.dto.UserDto;
import com.project.demohsbcapp.entity.Login;
import com.project.demohsbcapp.entity.User;

import com.project.demohsbcapp.exception.LoginException;
import com.project.demohsbcapp.service.LoginService;

@RestController
@RequestMapping("/login-service")
public class LoginController {
	@Autowired
	private LoginService service;
	
//	@Autowired
//	private LoginStatus status;

	@PostMapping("/login")
	public LoginStatus loginUser(@RequestBody Login login) throws Exception {
	    try {
	        String tempEmailId= login.getEmailId();
	        String tempPassword= login.getPassword();
//	        User user = null;
	        Login user = null;
	        if(tempEmailId != null && tempPassword != null) {
	            user = service.fetchLoginAdminByEmailIdAndPassword(login.getEmailId(), login.getPassword());
	        }
	        if(user==null){
	            throw new LoginException("Incorrect emailId and password");
	        }
	        System.out.println(user);
	        LoginStatus status = new LoginStatus();
	        status.setStatus(StatusType.SUCCESS);
	        status.setMessage("Login Successful!");
//	        status.setUserId(user.getEmpId());
//	        status.setUserId(user.getUserId());
	        return status;
	    } catch (LoginException e) {
	        LoginStatus status = new LoginStatus();
	        status.setStatus(StatusType.FAILED);
	        status.setMessage(e.getMessage());
	        return status;

	    }

	}
	
	
	
	@GetMapping("/getusers")
	public List<User> getUsers()
//	public List<UserDto> getUsers()
	{
//		List<UserDto> userRestList = new ArrayList<UserDto>();
//
//		List<User> userDTOList = service.getUsers();
//		
//		for (User user : userDTOList)
//		{
//			User userDTO= new User();
//			BeanUtils.copyProperties(user, userDTO);
//			userRestList.add(userDTO);
//		}
//		
//		return userRestList;
		
//		User user = new User();
		List<User> userList = service.getUsers();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
//		UserDto u = new UserDto();
//		for(User user:userList) {
//		u.setUserId(user.getUserId());
//		u.setDob(user.getDob());
//		u.setEmailId(user.getEmailId());
//		u.setName(user.getName());
//		userDtoList.add(u);
//		}
//		return userDtoList;
		return userList;
	}
	
	@DeleteMapping(path = "/{userId}")
	public String deleteUser(@PathVariable("userId") int userId )
	{
		
		
		service.deleteUser(userId);
		return "deleted";
		

	}
	

	@PostMapping(value = "/updateuser", produces = "application/json", consumes = "application/json")
	public Status updateUserDetails( @RequestBody User user) {

		Status status = new Status();
		try {
			User usernew = service.updateUser(user);
			status.setMessage("Updated Successfully !");
			status.setStatus(Status.StatusType.SUCCESS);
			return status;

		}
		catch(RuntimeException e) {
			status.setStatus(Status.StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
} 
