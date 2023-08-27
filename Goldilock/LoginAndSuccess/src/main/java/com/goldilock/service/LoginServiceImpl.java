package com.goldilock.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldilock.Repo.CurrentSessionDao;
import com.goldilock.Repo.UserDAO;
import com.goldilock.exception.LoginException;
import com.goldilock.model.CurrentSession;
import com.goldilock.model.LoginDTO;
import com.goldilock.model.User;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Override
	public Integer logIntoAccount(LoginDTO dto) {
		
		User usr = userDAO.findByUsername(dto.getUsername());
		
		if(usr==null) throw new LoginException("Invalid Username And Password");
		
		String pass = usr.getPassword();
		
		Optional<CurrentSession> currentSession= currentSessionDao.findById(usr.getEmpId());
		
		if(currentSession.isPresent()) {
			throw new LoginException("User is Already LoggedIn");
		}
		
		if(pass.equals(dto.getPassword())) {
			  
			int min = 1000; // Minimum value of range
		      int max = 9999; // Maximum value of range
		     
		      int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
			
		      int key= random_int;
		      
		      CurrentSession currentSession1 = new CurrentSession(usr.getEmpId(),key,LocalDateTime.now());
				
			  currentSessionDao.save(currentSession1);
			  
			  return key;
			  
			  
				
		}else {
			throw new LoginException("Invalid Username And Password");
		}

	}

	@Override
	public String logOutFromAccount(Integer key) {
		CurrentSession currentSession = currentSessionDao.findBySessionId(key);
		
		if(currentSession == null) {
			throw new LoginException("User Not Logged In with this username And password");
			
		}
		
		currentSessionDao.delete(currentSession);
		
		return "Logged Out !";
	}

}
