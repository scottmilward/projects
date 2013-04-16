package com.scott.common.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scott.common.models.UserLogin;
import com.scott.common.models.UserRegistration;
import com.scott.common.service.UserService;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {

		model.addAttribute("userlogin", new UserLogin());
		return "LoginForm";

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String home2(ModelMap model) {

		model.addAttribute("userregistration", new UserRegistration());
		return "RegistrationForm";

	}

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView processSubmit(
			@ModelAttribute("userlogin") @Valid UserLogin user,
			BindingResult results) {

		if (results.hasErrors()) {
			System.out.println("Errors");
			return new ModelAndView("LoginForm");
		}

		UserService userservice = new UserService();
		if(userservice.ValidateUserLogin(user))
			return new ModelAndView("done");
		else{
			results.reject("InvalidLogin");
		}
		
		return new ModelAndView("LoginForm");
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistration(
			@ModelAttribute("userregistration") @Valid UserRegistration user,
			BindingResult results) {
			
		if (results.hasErrors()) {
			return new ModelAndView("RegistrationForm");
		}
		
		UserService userservice = new UserService();
		if(userservice.ValidateRegistration(user, results))
			return new ModelAndView("done");
		
		return new ModelAndView("RegistrationForm"); 
	
			
		}
		
		
}


