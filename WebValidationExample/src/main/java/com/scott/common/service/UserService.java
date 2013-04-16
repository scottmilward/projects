package com.scott.common.service;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.validation.BindingResult;

import com.scott.common.models.UserLogin;
import com.scott.common.models.UserRegistration;

public class UserService {
	
	
	public boolean ValidateUserLogin(UserLogin user){
		
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String pass = passwordEncryptor.encryptPassword(user.getPassword());
		
		
		if(user.getUsername().toLowerCase().equals("scott") && user.getPassword().toLowerCase().equals("02106255"))
			return true;
		else
			return false;
	}
	
	public boolean ValidateRegistration(UserRegistration user, BindingResult results){
		
		if(!(user.getPassword().equals(user.getPassword2()))){
			results.reject("PasswordsMustMatch");
			return false;
		}
		
		return true;
		
	}

}
