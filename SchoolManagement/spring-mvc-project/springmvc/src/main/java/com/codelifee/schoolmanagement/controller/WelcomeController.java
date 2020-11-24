package com.codelifee.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codelifee.schoolmanagement.model.StudentDAO;
import com.codelifee.schoolmanagement.model.StudentDTO;

@Controller
public class WelcomeController {

	@Autowired
	public StudentDTO student;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String handleWelcome() {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
}
