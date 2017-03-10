package com.example.layer.in.entity;

public class Person {

	private int identifier;
	
	private String firstName;
	
	private String LastName;
	
	private Integer age;

	public Person() {};
	
	public Person(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.age = age;
	}

	public Person(int identifier, String firstName, String lastName, Integer age) {
		super();
		this.identifier = identifier;
		this.firstName = firstName;
		LastName = lastName;
		this.age = age;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
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
