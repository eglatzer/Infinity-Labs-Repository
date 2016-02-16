package com.ilad.printobject;

public class Name {
	String lastName;
	String firstName;
	
	// Constructor
	public Name(String lastName_, String firstName_) {
		lastName = lastName_;
		firstName = firstName_;
	}

	// Getters and Setters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName_) {
		lastName = lastName_;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName_) {
		firstName = firstName_;
	}
}