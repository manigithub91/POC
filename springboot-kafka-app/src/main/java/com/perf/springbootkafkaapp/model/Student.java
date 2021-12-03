package com.perf.springbootkafkaapp.model;// Java program to implement a

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// student class
@Entity
// Creating a student class
public class Student {

	// Data members of the class
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;

	// Constructor of the student
	// class
	public Student()
	{
	}

	// Parameterized constructor of
	// the student class
	public Student(Long id, String firstName,
				String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Student{"
			+ "id = " + id
			+ ", firstName = '" + firstName + "'"
			+ ", lastName = '" + lastName + "'"
			+ "}";
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
