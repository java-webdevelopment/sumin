package com.codelifee.schoolmanagement.model;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDTO {

	private String name;
	private String password;

	public StudentDTO() {
	}
	
	public StudentDTO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
