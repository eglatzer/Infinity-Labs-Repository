package com.ilad.printobject;

public class Date {
	int day;
	int month;
	int year;
	
	// Constructor
	public Date(int day_, int month_, int year_) {
		day = day_;
		month = month_;
		year = year_;
	}

	// Getters and Setters
	public int getDay() {
		return day;
	}

	public void setDay(byte day_) {
		day = day_;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(byte month_) {
		month = month_;
	}

	public int getYear() {
		return year;
	}

	public void setYear(byte year_) {
		year = year_;
	}
}