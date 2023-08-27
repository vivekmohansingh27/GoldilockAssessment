package com.goldilock.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldilock.model.CurrentSession;

@Repository
public interface CurrentSessionDao extends JpaRepository<CurrentSession, Integer>{

	public CurrentSession findBySessionId(Integer sessionId);
	
}
