package com.goldilock.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrentSession {
	
	@Id
	@Column(unique= true)
	private Integer id;
	
	private Integer sessionId;
	
	private LocalDateTime localDateTime;

	public CurrentSession(int id, int sessionId, LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.localDateTime = localDateTime;
		
	}

	public CurrentSession() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "CurrentSession [id=" + id + ", sessionId=" + sessionId + ", localDateTime=" + localDateTime + "]";
	}
	

}
