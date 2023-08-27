package com.goldilock.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldilock.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	
	public User findByUsername(String username);

}
