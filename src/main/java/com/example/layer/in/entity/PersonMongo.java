package com.example.layer.in.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PersonMongo {

	@Id
	private String identifier;
	
	private String firstName;
	
	private String LastName;
	
	private Integer age;

	public PersonMongo() {};
	
	public PersonMongo(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.age = age;
	}

	public PersonMongo(String identifier, String firstName, String lastName, Integer age) {
		super();
		this.identifier = identifier;
		this.firstName = firstName;
		LastName = lastName;
		this.age = age;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
