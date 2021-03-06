package com.ilad.printobject;

public class Person {
	int idNumber;
	Name name;
	Date dateOfBirth;
	Sex sex;
	
	// Constructor
	public Person(int idNumber_, Name name_, Date dateOfBirth_, Sex sex_) {
		idNumber = idNumber_;
		name = name_;
		dateOfBirth = dateOfBirth_;
		sex = sex_;
	}
	
	// Getters and Setters
	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber_) {
		idNumber = idNumber_;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name_) {
		name = name_;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth_) {
		dateOfBirth = dateOfBirth_;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex_) {
		sex = sex_;
	}

	// Sex enumerable
	public enum Sex {
		MALE(true), FEMALE(false);
		
		private boolean value;
		
		// Constructor
		private Sex(boolean value_) {
			value = value_;
		}
		
		// Getter
		public boolean getValue() {
			return value;
		}
	}
}
