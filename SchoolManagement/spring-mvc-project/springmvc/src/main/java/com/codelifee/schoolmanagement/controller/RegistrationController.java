package com.codelifee.schoolmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.codelifee.schoolmanagement.model.StudentDAO;
import com.codelifee.schoolmanagement.model.StudentDTO;

@Controller
@SessionAttributes("name")
public class RegistrationController {

	@Autowired
	public StudentDAO studentService;
	
	@Autowired
	public StudentDTO student;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegister(HttpServletRequest request, HttpServletResponse response) {
		
		return "register";
	}
	
	@RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	public String addUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		
		try {
			student.setName(name);
			student.setPassword(password);
			
			studentService.join(student);
			
			model.addAttribute("welcome", "registered");
			
			return "welcome";
		} catch(Exception e) {
			return "index";
		}	
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		request.getSession().setAttribute("name", request.getParameter("name"));
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		try {
			student.setName(name);
			student.setPassword(password);
			
			studentService.login(student.getName(),student.getPassword());
			
			model.addAttribute("welcome", "logged in");
			
			return "welcome";
		} catch(Exception e) {
			return "index";
		}	
	}
}
