package com.goldilock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer empId;
	
	@NotNull
	@NotBlank(message="Please fill the valid Name")
	@Size(min = 2, max = 50, message="Please fill the valid Name")
	private String empName;
	
	@NotNull
	@Min(value=0, message="Age should not be negative")
	private Integer empAge;
	
	@NotNull
	@Email
	private String username;
	
	@NotNull
	@NotBlank(message="Please fill the valid Password")
	@JsonProperty(access= Access.WRITE_ONLY)
	private String password;

	public User(Integer empId,
			@NotNull @NotBlank(message = "Please fill the valid Name") @Size(min = 2, max = 50, message = "Please fill the valid Name") String empName,
			@NotNull @Min(value = 0, message = "Age should not be negative") Integer empAge,
			@NotNull @Email String username,
			@NotNull @NotBlank(message = "Please fill the valid Password") String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	

}
