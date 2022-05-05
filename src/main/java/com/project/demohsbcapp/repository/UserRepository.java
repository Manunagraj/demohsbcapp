package com.project.demohsbcapp.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.demohsbcapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer>{

//     public User findByEmailIdAndPassword(String emailId , String Password);

	public User findByEmailIdAndPassword(String emailId, String password);
	
//    @Query(value = "DELETE FROM User e WHERE e.emailId = :emailId")    
	public long deleteByUserId(int userId);
	
	public User findByUserId(int userId);

//	public long deleteUser(int userId);
}
