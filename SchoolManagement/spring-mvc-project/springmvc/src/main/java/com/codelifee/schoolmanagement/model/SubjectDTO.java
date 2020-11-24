package com.codelifee.schoolmanagement.model;

import org.springframework.stereotype.Repository;

@Repository
public class SubjectDTO {

	private String subject;
	private String name;
	
	public SubjectDTO() {
		
	}
	
	public SubjectDTO(String subject, String name) {
		this.subject = subject;
		this.name = name;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
