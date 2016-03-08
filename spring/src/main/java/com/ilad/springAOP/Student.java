package com.ilad.springAOP;

public class Student {
	private Integer age;
	private String name;

	// Setters
	public void setAge(Integer age_) {
		age = age_;
	}

	public void setName(String name_) {
		name = name_;
	}

	// Getters
	public Integer getAge() {
		System.out.println("Age : " + age);
		return age;
	}

	public String getName() {
		System.out.println("Name : " + name);
		return name;
	}

	// Thrower
	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
}