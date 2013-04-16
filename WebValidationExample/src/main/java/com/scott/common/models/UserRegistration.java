package com.scott.common.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRegistration {
	
	@NotEmpty(message = "Please enter a Firstname!") 
	private String firstname;
	@NotEmpty(message = "Please enter a Lastname!") 
	private String lastname;
	@NotEmpty(message = "Please enter an Email!") 
	@Email(message= "Please enter a valid Email Address")
	private String email;
	@NotEmpty(message = "Please enter a Username!") 
	private String username;
	@Size(min=7 ,message = "Password must be at least 7 characters")
	private String password; 
	private String password2;
	
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	
	
	
	

	
	
	
	

	
	

	

	
	
	
	
	
	
	
	

}
