package com.goldilock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldilock.Repo.UserDAO;
import com.goldilock.exception.UserException;
import com.goldilock.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User addUser(User user) {
		
		if(user==null)throw new UserException("User Not Found");
		
		User usr = userDAO.save(user);
		
		return null;
	}
	
	
	public List<User> getAllUser(){
		
		List<User> users = userDAO.findAll();
		
		if(users.isEmpty()) {
			throw new UserException("Users Not Found");
		}
		
		return users; 
		
	}
	
	

}
