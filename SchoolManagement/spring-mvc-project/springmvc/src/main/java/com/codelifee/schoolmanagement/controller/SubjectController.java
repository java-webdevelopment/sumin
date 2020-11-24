package com.codelifee.schoolmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codelifee.schoolmanagement.model.SubjectDAO;
import com.codelifee.schoolmanagement.model.SubjectDTO;

@Controller
public class SubjectController {

	@Autowired
	public SubjectDAO service;
	
	@Autowired
	public SubjectDTO subject;
	
	@RequestMapping(value="/subjects", method = RequestMethod.GET)
	public String goSubjects() {
		
		return "subjects";
	}
	
	@RequestMapping(value="/subjectSearch", method = RequestMethod.GET)
	public String goSubjectSearch() {
		
		return "subjectSearch";
		
	}
	
	@RequestMapping(value="/subjectSearch", method = RequestMethod.POST)
	public String showSubject(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		
		model.addAttribute("subjects", service.getList(name));
		
		return "subjectSearch";
		
	}
	
	@RequestMapping(value="/subjectAdd", method = RequestMethod.GET)
	public String goAddSubject() {
		
		return "subjectAdd";
	}
	
	@RequestMapping(value="/subjectAdd", method = RequestMethod.POST)
	public String addSubject(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
				
		String name= request.getParameter("name");
		String sub = request.getParameter("subjectDivide");
		
		subject.setName(name);
		subject.setSubject(sub);
		
		service.addSubject(subject);
		
		model.addAttribute("welcome", "added");
		
		return "welcome";
	}
	
	@RequestMapping(path="/subjectDelete", method= RequestMethod.GET)
	public String deleteSubject(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String subject = request.getParameter("subject");
		
		int result = service.delete(subject);
		
		if(result == 1) {
			model.addAttribute("welcome", "deleted");
			
			return "welcome";
		}
		
		return "error";
	}
	
	
}
